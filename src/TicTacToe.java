public class TicTacToe {
    private int [][] board;

    public TicTacToe () {
        board = new int[][] {{0 , 0 , 0},{0 , 0 , 0},{0 , 0 , 0}};
    }

    public void printBoard () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] == 0 || board[i][j] == 1 || board[i][j] == 2) {
                    if (board[i][j] == 0) {
                        System.out.print(" ");
                    }
                    if (board[i][j] == 1) {
                        System.out.print("X");
                    }
                    if (board[i][j] == 2) {
                        System.out.print("O");
                    }
                }
                if (j < 2) {
                    System.out.print(" |");
                }
            }
            if (i < 2) {
                System.out.println();
                System.out.println("---------");

            }
        }
    }


}
