package linea;

public class Linea {
    public char[][] board;
    private TriunfoStrategy triunfoStrategy;
    public int columnas;
    public int filas;
    private boolean esTurnoRojas;
    private char ultimoJugador;


    public Linea(int columnas, int filas, char winningVariant) {
        this.columnas = columnas;
        this.filas = filas;
        this.board = new char[filas][columnas];
        this.esTurnoRojas = true; //Rojas comienzan
        initializeStrategy(winningVariant);
        initializeBoard();
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

    public boolean finished() {
        // Antes de llamar a checkWin, asegúrate de que ultimoJugador tenga un valor válido.
        return ultimoJugador != '\0' && triunfoStrategy.checkWin(board, ultimoJugador) || isBoardFull();
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

    public void playRedAt(int column) {
        if (esTurnoRojas) {
            if (isValidMove(column)) {
                dropPiece(column, 'R');
                ultimoJugador = 'R'; // Agregar esta línea
                esTurnoRojas = false; // Cambio de turno
            } else {
                System.out.println("Columna llena. Elige otra columna.");
            }
        } else {
            throw new IllegalStateException("No es el turno de las rojas");
        }
    }
    public void playBlueAt(int column) {
        if (!esTurnoRojas) {
            if (isValidMove(column)) {
                dropPiece(column, 'B');
                ultimoJugador = 'B'; // Agregar esta línea
                esTurnoRojas = true; // Cambio de turno
            } else {
                System.out.println("Columna llena. Elige otra columna.");
            }
        } else {
            throw new IllegalStateException("No es el turno de las azules");
        }
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

        // Mostrar el mensaje del jugador actual
        display.append(esTurnoRojas ? "> Playing Red <" : "> Playing Blue <").append("\n");
        return display.toString();
    }

    public char[][] getBoard() {
        return board;
    }
    public boolean isEsTurnoRojas() {
        return esTurnoRojas;
    }
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
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
