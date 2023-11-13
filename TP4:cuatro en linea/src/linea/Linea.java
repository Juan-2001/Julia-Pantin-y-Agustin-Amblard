package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
    private PlayingMode modoDeJuego;
    private EstadoJuego estadoDeJuego;
    public static char emptySpace = '·';
    public static char redPlayer = 'X';;
    public static char bluePlayer= 'O';
    private List<List<Character>> board;
    private final int base;
    private final int height;
    private boolean finished;

    public Linea(int columnas, int filas, char mode) {
        this.base = columnas;
        this.height = filas;
        this.modoDeJuego = PlayingMode.getModoDeJuegoFor( mode );
        this.estadoDeJuego = new JuegaRojo();
        if (base < 4 || height < 4) { throw new RuntimeException("Base and height have to be above 3."); }
        this.board = IntStream.range(0, this.base)
                .mapToObj(i -> new ArrayList<Character>())
                .collect(Collectors.toList());
    }
    public boolean finished() { return this.getStatus().isFinished(); }

    public void playRedAt( int column ) {
        this.estadoDeJuego = estadoDeJuego.playRedAs( column, this);
        checkIfGameOver( redPlayer );
    }

    public void playBlueAt( int column ) {
        this.estadoDeJuego = estadoDeJuego.playBlueAs( column, this);
        checkIfGameOver( bluePlayer );
    }

    public void dropPieceInColumn( int column, char player ) {
        column = column - 1;
        if ( !isColumnInBounds( column )) {
            throw new RuntimeException("The column is not between 1 and " + this.base);
        }
        if ( this.board.get( column ).size() == this.height) {
            throw new RuntimeException("Column " + (column + 1)+ " is full.");
        }
        this.board.get( column ).add( player );
        this.finished = modoDeJuego.checkWin( player, this );
    }

    public char getCharAt(int row, int column) {
        int expectedRow = this.height - 1 - row;
        if (isColumnInBounds( column ) && expectedRow < this.board.get(column).size() && expectedRow >= 0) {
            return this.board.get(column).get(expectedRow);
        }
        return emptySpace;
    }
    public boolean victoriaVertical(char player) {
        return IntStream.range(0, this.getBase())
                .anyMatch(column -> IntStream.range(0, this.getHeight() - 3)
                        .anyMatch(row -> IntStream.range(0, 4)
                                .allMatch(i -> this.getCharAt(row + i, column) == player)));
    }

    public boolean victoriaHorizontal(char player) {
        return IntStream.range(0, this.getHeight())
                .anyMatch(row -> IntStream.range(0, this.getBase() - 3)
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> this.getCharAt(row, column + i) == player)));
    }

    public boolean victoriaDiagonal(char player) {
        return IntStream.range(0, this.getHeight() - 3)
                .anyMatch(row -> IntStream.range(0, this.getBase() - 3)
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> this.getCharAt(row + i, column + i) == player)))
                || IntStream.range(0, this.getHeight() - 3)
                .anyMatch(row -> IntStream.range(3, this.getBase())
                        .anyMatch(column -> IntStream.range(0, 4)
                                .allMatch(i -> this.getCharAt(row + i, column - i) == player)));
    }

    public String show() {
        String playingSlots = IntStream.range(0, this.height)
                .mapToObj(i -> "| " + IntStream.range(0, this.base)
                        .mapToObj(j -> String.valueOf(this.getCharAt(i, j)))
                        .collect(Collectors.joining(" "))
                        + " |\n")
                .collect(Collectors.joining());
        String bottom = "|" + "^".repeat(this.base * 2 + 1) + "|";
        String turn = estadoDeJuego.getStatus() + "\n" ;
        return "\n" + playingSlots + bottom + "\n" + turn;
    }


//ACCESSORS
    private void checkIfGameOver(char slot) {
        if ( this.finished) {
            this.estadoDeJuego = new GameOver( slot );
        }
    }
    private boolean isColumnInBounds(int desiredColumn) {
        return desiredColumn >= 0 && desiredColumn < this.base;
    }
    public int getHeight() {
        return this.height;
    }
    public int getBase() {
        return this.base;
    }
    public List<List<Character>> getBoard() {
        return this.board;
    }
    public EstadoJuego getStatus() {
        return this.estadoDeJuego;
    }
}
