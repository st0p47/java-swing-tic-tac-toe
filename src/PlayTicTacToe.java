import java.awt.*;
import javax.swing.*;

public class PlayTicTacToe {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton gridButtons [] = new JButton[9];
        JButton restartButton = new JButton();
        pane.setLayout(new GridBagLayout());

        for (int i = 0; i < 9; i++) {
            gridButtons[i] = new JButton();
        }

        int buttonCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 0.5;
                c.weighty = 0.5;
                c.gridx = i;
                c.gridy = j;
                pane.add(gridButtons[buttonCount], c);
                buttonCount++;
            }
        }

        //restartButton
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.insets = new Insets(20,0,0,0);  //top padding
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 3;
        pane.add(restartButton, c);
    }
    private static void createAndShowGUI() {
        //copied from GridBagLayout Tutorial haHAA
        //Create and set up the window.
        JFrame frame = new JFrame("TicTacToe maybe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.setSize(300 , 420);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //copied this too
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
