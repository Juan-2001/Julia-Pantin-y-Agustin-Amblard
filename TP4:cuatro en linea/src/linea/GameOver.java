package linea;

public class GameOver extends EstadoJuego {
    public GameOver(Linea juego) {
        super(juego);
    }
    public void handle(int columna) {
        // No hacer nada, termino.
    }
    public String jugadorActual() {
        return "Game Over";
    }

}
