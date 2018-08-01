public class PlayTicTacToe {
    public static void main (String [] args) {
        TicTacToeGUI game = new TicTacToeGUI();

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //copied this too

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                game.createAndShowGUI();
            }
        });
        game.playGame();

    }
}
