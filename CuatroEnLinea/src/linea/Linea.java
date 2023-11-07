package linea;

public class Linea {
    public String NOESTURNO = "No es turno";
    public char[][] board;
    public int columnas;
    public int filas;
    public char winningVariant;
    public String turno;

    public Linea(int columnas, int filas, char winningVariant) {
        this.columnas = columnas;
        this.filas = filas;
        this.winningVariant = winningVariant;
        this.board = new char[filas][columnas];
        this.turno = "rojas"; // Establecer el turno inicial en "rojas"
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public String show() {
        StringBuilder display = new StringBuilder();

        // Mostrar el tablero
        for (int i = 0; i < filas; i++) {
            display.append("| ");
            for (int j = 0; j < columnas; j++) {
                display.append(board[i][j] == ' ' ? "- " : board[i][j] + " ");
            }
            display.append("|\n");
        }

        // Mostrar las coordenadas de las columnas en la última fila
        display.append("| ");
        for (int k = 0; k < columnas; k++) {
            display.append("^ ");
        }
        display.append("|\n");

        // Mostrar el mensaje del jugador actual
        display.append(turnoRojas() ? "> Playing Red <" : "> Playing Blue <").append("\n");

        return display.toString();
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean turnoRojas() {
        return getTurno() == "rojas";
    }

    public boolean turnoAzules() {
        return getTurno() == "azules";
    }


    private String getTurno() {
        return turno;
    }


    public boolean finished() {
        // Implementar lógica para verificar si el juego ha terminado
        // Puedes usar esta función para verificar si hay un ganador o si es un empate
        // y actualizar el estado del juego en consecuencia.
        return false;
    }

    public void playRedAt(int column) {
        if (turnoRojas()) {
            if (isValidMove(column)) {
                dropPiece(column, 'O'); // 'R' representa las fichas rojas
                setTurno("azules");
            } else {
                System.out.println("Columna llena. Elige otra columna.");
            }
        } else {
            throw new Error(NOESTURNO);
        }
    }
    public void playBlueAt(int column) {
        if (turnoAzules()) {
            if (isValidMove(column)) {
                dropPiece(column, 'X'); // 'R' representa las fichas rojas
                setTurno("rojas");
            } else {
                System.out.println("Columna llena. Elige otra columna.");
            }
        } else {
            throw new Error(NOESTURNO);
        }
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
