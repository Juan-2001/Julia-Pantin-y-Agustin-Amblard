package linea;

public class TriunfoDiagonal implements TriunfoStrategy{
    public boolean checkWin(char [][] board, char player){
        return victoriaDiagonal(board, player);
    }
    static boolean victoriaDiagonal(char[][] board, char player) {
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i+1][j+1] == player &&
                        board[i+2][j+2] == player && board[i+3][j+3] == player) {
                    return true;
                }}}
        return false;}
}
