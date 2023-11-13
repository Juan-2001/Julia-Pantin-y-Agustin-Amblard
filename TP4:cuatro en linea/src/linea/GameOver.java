package linea;

public class GameOver extends EstadoJuego {
    public String GAME_OVER = "Game Over!";
    private final String winner;
    public GameOver(char winner) {
        this.winner = winner == Linea.redPlayer ? "Red" : "Blue";
    }
    public EstadoJuego playRedAs(int desiredColumn, Linea game) {
        throw new RuntimeException(GAME_OVER);
    }
    public EstadoJuego playBlueAs(int desiredColumn, Linea game) {
        throw new RuntimeException(GAME_OVER);
    }
    public String getStatus() {
        return "Game Over! \nWinner: " + this.winner;
    }
    public boolean isFinished() {
        return true;
    }
    public boolean equals(Object other) {
        if (other.getClass() == GameOver.class) {
            return this.getStatus().equals(((GameOver) other).getStatus());
        }
        return false;
    }
}
