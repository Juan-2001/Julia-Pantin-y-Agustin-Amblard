package linea;


public class ModeC extends PlayingMode {

    public ModeC() {
        this.symbol = 'C';
    }

    public boolean checkWin(char player, Linea game) {
        return game.victoriaHorizontal(player) ||game.victoriaVertical(player)
                ||game.victoriaDiagonal(player);
    }
}
