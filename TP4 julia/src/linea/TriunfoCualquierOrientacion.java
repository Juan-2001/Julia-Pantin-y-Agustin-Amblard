package linea;

public class TriunfoCualquierOrientacion implements TriunfoStrategy{
    public boolean checkWin(char [][] board, char player){
        //Implementacion de la logica de comprobacion de victoria vertical, horizontal y Diagonal
        // Comprobar victoria horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i][j+1] == player &&
                        board[i][j+2] == player && board[i][j+3] == player) {
                    return true;
                }
            }
        }
        // Comprobar victoria vertical
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player && board[i+1][j] == player &&
                        board[i+2][j] == player && board[i+3][j] == player) {
                    return true;
                }
            }
        }
        //Comprobar victoria diagonal
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == player && board[i+1][j+1] == player &&
                        board[i+2][j+2] == player && board[i+3][j+3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
}
