package linea;

public class Empate extends EstadoJuego {
    private final String empateMessage = "Draw!";

    public EstadoJuego playRedAs(int column, Linea game) {
        throw new RuntimeException(empateMessage);
    }


    public EstadoJuego playBlueAs(int column, Linea game) {
        throw new RuntimeException(empateMessage);
    }

    public String getStatus() {
        return empateMessage;
    }

    public boolean isFinished() { return true; }

}
