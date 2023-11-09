package linea;

public class JuegaAzul extends EstadoJuego{
    public JuegaAzul(Linea juego) {
        super(juego);
    }
    public void handle(int columna) {
        juego.playBlueAt(columna);
        if (!juego.finished()) {
            juego.setEstado(new JuegaRojo(juego));
        } else {
            juego.setEstado(new GameOver(juego));
        }
    }
    public String jugadorActual() {
        return "> Playing Blue <";
    }
}
