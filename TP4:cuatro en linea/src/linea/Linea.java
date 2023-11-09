package linea;

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
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (board[i][j] == ' ') {
                    return false; // Encontró un espacio vacío, el tablero no está lleno
                }
            }
        }
        return true; // No hay espacios vacíos, el tablero está lleno
    }

    public void setEstado(EstadoJuego nuevoestado) {
        this.estadoActual = nuevoestado;
    }
    public void playRedAt(int column) {
        if (isValidMove(column)) {
            dropPiece(column, 'R');
            if (triunfoStrategy.checkWin(board, 'R') || isBoardFull()) {
                setEstado(new GameOver(this));
            } else {
                setEstado(new JuegaAzul(this));
            }
        } else {
            System.out.println("Columna llena. Elige otra columna.");
        }
    }
    public void playBlueAt(int column) {
        if (isValidMove(column)) {
            dropPiece(column, 'B');
            if (triunfoStrategy.checkWin(board, 'B') || isBoardFull()) {
                setEstado(new GameOver(this));
            } else {
                setEstado(new JuegaRojo(this));
            }
        } else {
            System.out.println("Columna llena. Elige otra columna.");
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


    public char[][] getBoard() {
        return board;
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
            }
        }
    }

    private boolean isValidMove(int column) {
        return board[0][column] == ' '; // Verificar si la columna no está llena
    }
}
