package linea;


public class ModeA extends PlayingMode {

    public ModeA() {
        this.symbol = 'A';
    }

    public boolean checkWin(char player, Linea game) {
        return game.victoriaHorizontal(player) || game.victoriaVertical(player);
    }

}
