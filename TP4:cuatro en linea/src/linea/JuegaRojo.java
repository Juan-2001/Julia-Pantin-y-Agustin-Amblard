package linea;

public class JuegaRojo extends EstadoJuego{
    public JuegaRojo(Linea juego) {
        super(juego);
    }
    public void handle(int columna) {
        juego.playAt(columna, 'R');
    }
    public String jugadorActual() {
        return "> Playing Red <";
    }
}
