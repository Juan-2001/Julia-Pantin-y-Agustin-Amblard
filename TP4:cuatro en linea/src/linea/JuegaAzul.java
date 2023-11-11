package linea;

public class JuegaAzul extends EstadoJuego{
    public JuegaAzul(Linea juego) {
        super(juego);
    }
    public void handle(int columna) {
        juego.playAt(columna, 'B');
    }
    public String jugadorActual() {
        return "> Playing Blue <";
    }
}
