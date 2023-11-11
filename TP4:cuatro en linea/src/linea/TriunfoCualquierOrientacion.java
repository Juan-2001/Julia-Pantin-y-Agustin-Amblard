package linea;

public class TriunfoCualquierOrientacion implements TriunfoStrategy{
    public boolean checkWin(char [][] board, char player) {
        if (TriunfoVerticalHorizontal.victoriaHorizontal(board, player)) return true;
        if (TriunfoVerticalHorizontal.victoriaVertical(board, player)) return true;
        return TriunfoDiagonal.victoriaDiagonal(board, player);
    }}
