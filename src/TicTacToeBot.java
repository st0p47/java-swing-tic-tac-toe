public class TicTacToeBot {
    private TicTacToe game;
    private int [] [] board = new int[3][3];
    private String [] patternsX = {"0011" , "0101" , "0110"};
    private String [] patternsO = {"0022" , "0202" , "0220"};
    private String patternCheck;

    public TicTacToeBot (TicTacToe game) {
        board = game.getBoard();
    }

    /*
    This method makes a move for a given player based on a predetermined strategy.
    First it attempts to complete any possible line, then attempts to block any lines,
    and if neither is present, moves randomly to an open spot.
    */
    public int [] botMove (int player) {
        int [] moveCoords = {0, 0};
        boolean madeMove = false;
        //Complete for win
        // Horizontal Check
        for (int i = 0; i < 3; i++) {
            patternCheck = "0";
            for (int j = 0; j < 3; j++) {
                patternCheck += Integer.toString(board[j][i]);
            }
            for (int s = 0; s < 3; s++) {
                if (player == 0) {
                    if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                        moveCoords[0] = i;
                        moveCoords[1] = s;
                        madeMove = true;
                    }
                }
                if (player == 1) {
                    if (patternCheck.equals(patternsO[s]) && !madeMove)  {
                        moveCoords[0] = i;
                        moveCoords[1] = s;
                        madeMove = true;
                    }
                }
            }
        }
        //Vertical Check
        for (int i = 0; i < 3; i++) {
            patternCheck = "0";
            for (int j = 0; j < 3; j++) {
                patternCheck += Integer.toString(board[i][j]);
            }

            for (int s = 0; s < 3; s++) {
                if (player == 0) {
                    if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                        moveCoords[0] = s;
                        moveCoords[1] = i;
                        madeMove = true;
                    }
                }
                if (player == 1) {
                    if (patternCheck.equals(patternsO[s]) && !madeMove) {
                        moveCoords[0] = s;
                        moveCoords[1] = i;
                        madeMove = true;
                    }
                }
            }
        }
        // Top-left to bottom-right check
        patternCheck = "0";
        for (int j = 0; j < 3; j++) {
            patternCheck += Integer.toString(board[j][j]);
        }
        for (int s = 0; s < 3; s++) {
            if (player == 0) {
                if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                    moveCoords[0] = s;
                    moveCoords[1] = s;
                    madeMove = true;
                }
            }
            if (player == 1) {
                if (patternCheck.equals(patternsO[s]) && !madeMove) {
                    moveCoords[0] = s;
                    moveCoords[1] = s;
                    madeMove = true;
                }
            }
        }
        //Top-right to bottom-left check
        patternCheck = "0";
        int m = 2;
        for (int j = 0; j < 3; j++) {
            patternCheck += Integer.toString(board[j][m]);
            m--;
        }
        for (int s = 0; s < 3; s++) {
            if (player == 0) {
                if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                    moveCoords[0] = s;
                    moveCoords[1] = 3 - s;
                    madeMove = true;
                }
            }
            if (player == 1) {
                if (patternCheck.equals(patternsO[s]) && !madeMove) {
                    moveCoords[0] = s;
                    moveCoords[1] = 3 - s;
                    madeMove = true;
                }
            }
        }
        //Block enemy win
        // Horizontal Check
        for (int i = 0; i < 3; i++) {
            patternCheck = "0";
            for (int j = 0; j < 3; j++) {
                patternCheck += Integer.toString(board[j][i]);
            }
            for (int s = 0; s < 3; s++) {
                if (player == 1) {
                    if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                        moveCoords[0] = i;
                        moveCoords[1] = s;
                        madeMove = true;
                    }
                }
                if (player == 0) {
                    if (patternCheck.equals(patternsO[s]) && !madeMove)  {
                        moveCoords[0] = i;
                        moveCoords[1] = s;
                        madeMove = true;
                    }
                }
            }
        }
        //Vertical Check
        for (int i = 0; i < 3; i++) {
            patternCheck = "0";
            for (int j = 0; j < 3; j++) {
                patternCheck += Integer.toString(board[i][j]);
            }

            for (int s = 0; s < 3; s++) {
                if (player == 1) {
                    if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                        moveCoords[0] = s;
                        moveCoords[1] = i;
                        madeMove = true;
                    }
                }
                if (player == 0) {
                    if (patternCheck.equals(patternsO[s]) && !madeMove) {
                        moveCoords[0] = s;
                        moveCoords[1] = i;
                        madeMove = true;
                    }
                }
            }
        }
        // Top-left to bottom-right check
        patternCheck = "0";
        for (int j = 0; j < 3; j++) {
            patternCheck += Integer.toString(board[j][j]);
        }
        for (int s = 0; s < 3; s++) {
            if (player == 1) {
                if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                    moveCoords[0] = s;
                    moveCoords[1] = s;
                    madeMove = true;
                }
            }
            if (player == 0) {
                if (patternCheck.equals(patternsO[s]) && !madeMove) {
                    moveCoords[0] = s;
                    moveCoords[1] = s;
                    madeMove = true;
                }
            }
        }
        //Top-right to bottom-left check
        patternCheck = "0";
        int n = 2;
        for (int j = 0; j < 3; j++) {
            patternCheck += Integer.toString(board[j][n]);
            n--;
        }
        for (int s = 0; s < 3; s++) {
            if (player == 1) {
                if (patternCheck.equals(patternsX[s]) && !madeMove)  {
                    moveCoords[0] = s;
                    moveCoords[1] = 3 - s;
                    madeMove = true;
                }
            }
            if (player == 0) {
                if (patternCheck.equals(patternsO[s]) && !madeMove) {
                    moveCoords[0] = s;
                    moveCoords[1] = 3 - s;
                    madeMove = true;
                }
            }
        }
        //Random move to open space
        if (!madeMove) {
            int openSpaceCounter = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        openSpaceCounter++;
                    }
                }
            }
            int [] [] openSpaces = new int[openSpaceCounter][2];
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        openSpaces[count][0] = i;
                        openSpaces[count][1] = j;
                        count++;
                    }
                }
            }
            int choose = (int)(Math.random() * openSpaces.length);
            moveCoords[0] = openSpaces[choose][0];
            moveCoords[1] = openSpaces[choose][1];
            madeMove = true;
        }
         if (!madeMove) {
             System.out.println("avootu akbar");
         }
        return moveCoords;
    }
}
