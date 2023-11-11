package linea;

import java.util.Arrays;

public class Linea {
    public char[][] board;
    private TriunfoStrategy triunfoStrategy;
    public int columnas;
    public int filas;
    private EstadoJuego estadoActual;

    public Linea(int columnas, int filas, char winningVariant) {
        this.columnas = columnas;
        this.filas = filas;
        this.board = new char[filas][columnas];
        initializeStrategy(winningVariant);
        initializeBoard();
        this.estadoActual = new JuegaRojo(this);
    }
    private void initializeStrategy(char winningVariant) {
        switch (winningVariant) {
            case 'A':
                triunfoStrategy = new TriunfoVerticalHorizontal();
                break;
            case 'B':
                triunfoStrategy = new TriunfoDiagonal();
                break;
            case 'C':
                triunfoStrategy = new TriunfoCualquierOrientacion();
                break;
            default:
                throw new IllegalArgumentException("Tipo de juego no válido");
        }}
    private void initializeBoard() {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }
    private boolean isBoardFull() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (board[i][j] == ' ') {
                    return false; // Encontró un espacio vacío, el tablero no está lleno
                }}}
        return true; // No hay espacios vacíos, el tablero está lleno
    }

    public void setEstado(EstadoJuego nuevoestado) {
        this.estadoActual = nuevoestado;
    }
    public void playAt(int column, char player) {
        if (estadoActual instanceof GameOver) {
            throw new IllegalStateException("El juego ha terminado. No se pueden realizar más movimientos.");
        }
        if ((player == 'R' && !(estadoActual instanceof JuegaRojo)) ||
                (player == 'B' && !(estadoActual instanceof JuegaAzul))) {
            throw new IllegalStateException("No es el turno de " + (player == 'R' ? "las rojas" : "las azules"));
        }
        realizarJugada(column, player);
    }
    public void playRedAt(int column) {
        playAt(column, 'R');
    }
    public void playBlueAt(int column) {
        playAt(column, 'B');
    }
    private boolean isValidMove(int column) {
        return board[0][column] == ' '; // Verifica si la parte superior de la columna está vacía
    }

    private void realizarJugada(int column, char jugador) {
        if (!isValidMove(column)) {
            throw new IllegalStateException("Columna llena. Elige otra columna.");
        }
        dropPiece(column, jugador);
        actualizarEstadoDespuesDeJugar(jugador);
    }
    private void actualizarEstadoDespuesDeJugar(char jugador) {
        if (triunfoStrategy.checkWin(board, jugador) || isBoardFull()) {
            setEstado(new GameOver(this));
        } else {
            setEstado(jugador == 'R' ? new JuegaAzul(this) : new JuegaRojo(this));
        }
    }
    public boolean finished() {
        return estadoActual instanceof GameOver;
    }

    public String show() {
        StringBuilder display = new StringBuilder();
        // Mostrar el tablero
        for (int i = 0; i < filas; i++) {
            display.append("|");
            for (int j = 0; j < columnas; j++) {
                display.append(" ").append(board[i][j] == ' ' ? "-" : board[i][j]);
            }
            display.append(" |\n");
        }
        // Mostrar las coordenadas de las columnas en la última fila
        display.append("|");
        for (int k = 0; k < columnas; k++) {
            display.append(" ^");
        }
        display.append(" |\n");
        // Mostrar el mensaje del jugador actual o que el juego ha terminado
        display.append(estadoActual.jugadorActual()).append("\n");
        return display.toString();
    }
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public EstadoJuego getEstadoActual() {
        return estadoActual;
    }
    private void dropPiece(int column, char piece) {
        for (int i = filas - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = piece;
                break;
            }}}
}
