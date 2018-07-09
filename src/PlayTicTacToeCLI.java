//Used for testing the TicTacToe class in development before implementing with Swing
public class PlayTicTacToeCLI {
    public static void main (String [] args) {
        TicTacToe game = new TicTacToe();

        game.printBoard();
        System.out.println();
        game.checkWin();
        System.out.println(game.getWinCheck());
        System.out.println();
        System.out.println(game.getWinner());
    }
}
