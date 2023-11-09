package linea;

public class JuegaRojo extends EstadoJuego{
    public JuegaRojo(Linea juego) {
        super(juego);
    }
    public void handle(int columna) {
        juego.playRedAt(columna);
        if (!juego.finished()) {
            juego.setEstado(new JuegaAzul(juego));
        } else {
            juego.setEstado(new GameOver(juego));
        }
    }
    public String jugadorActual() {
        return "> Playing Red <";
    }
}
