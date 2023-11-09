package linea;

public abstract class EstadoJuego {
    protected Linea juego;
    public EstadoJuego(Linea juego) {
        this.juego = juego;
    }
    public abstract void handle(int columna);
    public abstract String jugadorActual();
}
