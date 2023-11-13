package linea;


public class ModeB extends PlayingMode {

    public ModeB() {
        this.symbol = 'B';
    }

    public boolean checkWin(char player, Linea game) {
        return game.victoriaDiagonal(player);
    }

}
