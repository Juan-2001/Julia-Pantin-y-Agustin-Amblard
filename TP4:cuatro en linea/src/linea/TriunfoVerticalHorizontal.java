package linea;

public class TriunfoVerticalHorizontal implements TriunfoStrategy{
    public boolean checkWin(char[][] board, char player) {
        // Verificar victoria horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player &&
                        board[i][j + 2] == player && board[i][j + 3] == player) {
                    System.out.println("Horizontal win detected");
                    return true;
                }
            }
        }

        // Verificar victoria vertical
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length - 3; i++) {
                if (board[i][j] == player && board[i + 1][j] == player &&
                        board[i + 2][j] == player && board[i + 3][j] == player) {
                    System.out.println("Vertical win detected");
                    return true;
                }
            }
        }

        return false;
    }
}
