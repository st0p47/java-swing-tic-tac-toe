public class TicTacToe {
    private int [][] board;
    private String winCheck;
    private int winner;

    public TicTacToe () {
        board = new int[][] {{0 , 0 , 0},
                                            {0 , 0 , 0},
                                            {0 , 0 , 0}};
        winner = 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getWinner() {
        return winner;
    }

    public String getWinCheck() {
        return winCheck;
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
    public void makeAMove (int x, int y, int z) {
        if (board[x][y] == 0) {
            board[x][y] = z;
        }
    }
    public void checkWin () {
        for (int i = 0; i < 3; i++) {
            winCheck = "0";
            for (int j = 0; j < 3; j++) {
                winCheck += Integer.toString(board[j][i]);
            }
            if (winCheck.equals("0111")) {
                winner = 1;
            }
            if (winCheck.equals("0222")) {
                winner = 2;
            }
        }
        for (int i = 0; i < 3; i++) {
            winCheck = "0";
            for (int j = 0; j < 3; j++) {
                winCheck += Integer.toString(board[i][j]);
            }
            if (winCheck.equals("0111")) {
                winner = 1;
            }
            if (winCheck.equals("0222")) {
                winner = 2;
            }
        }

        winCheck = "0";
        for (int j = 0; j < 3; j++) {
            winCheck += Integer.toString(board[j][j]);
        }

        if (winCheck.equals("0111")) {
            winner = 1;
        }
        if (winCheck.equals("0222")) {
            winner = 2;
        }

        winCheck = "0";
        int i = 2;
        for (int j = 0; j < 3; j++) {
            winCheck += Integer.toString(board[j][i]);
            i--;
        }
        if (winCheck.equals("0111")) {
            winner = 1;
        }
        if (winCheck.equals("0222")) {
            winner = 2;
        }
    }


}
