package linea;

public abstract class EstadoJuego {

    public abstract EstadoJuego playRedAs(int column, Linea game);
    public abstract EstadoJuego playBlueAs(int column, Linea game);
    public abstract String getStatus();
    public boolean isDraw(Linea game) {
        return game.getBoard().stream().allMatch(column -> column.size() == game.getHeight());
    }
    public boolean equals(Object other) {
        return other.getClass() == this.getClass();
    }
    public boolean isFinished() {
        return false;
    }
}
