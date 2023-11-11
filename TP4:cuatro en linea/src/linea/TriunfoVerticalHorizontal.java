package linea;

public class TriunfoVerticalHorizontal implements TriunfoStrategy{
    public boolean checkWin(char[][] board, char player) {
        if (victoriaHorizontal(board, player)) return true;
        return victoriaVertical(board, player);
    }

    static boolean victoriaVertical(char[][] board, char player) {
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length - 3; i++) {
                if (board[i][j] == player && board[i + 1][j] == player &&
                        board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }}}
        return false;}

    static boolean victoriaHorizontal(char[][] board, char player) {
        for (char[] chars : board) {
            for (int j = 0; j < chars.length - 3; j++) {
                if (chars[j] == player && chars[j + 1] == player &&
                        chars[j + 2] == player && chars[j + 3] == player) {
                    return true;
                }}}
        return false;}
}
