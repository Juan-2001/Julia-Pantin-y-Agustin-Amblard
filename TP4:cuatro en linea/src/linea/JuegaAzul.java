package linea;

public class JuegaAzul extends EstadoJuego{
    public EstadoJuego playRedAs(int column, Linea game) {
        throw new RuntimeException("Not red's turn");
    }

    public EstadoJuego playBlueAs(int column, Linea game) {
        game.dropPieceInColumn(column, Linea.bluePlayer);
        return this.isDraw(game) ? new Empate() : new JuegaRojo();
    }

    public String getStatus() {
        return "> Playing Blue <";
    }
}
