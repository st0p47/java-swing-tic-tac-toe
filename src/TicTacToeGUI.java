import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToeGUI implements ActionListener {
    private TicTacToe game;
    private JFrame frame = new JFrame("TicTacToe maybe");
    private JButton gridButtons [][] = new JButton[3][3];
    private int turn = 1;
    private JLabel informationBoard = new JLabel();
    private boolean keepPlaying = true;
    private JFrame restartPrompt = new JFrame("Restart");
    private int XScore = 0;
    private int OScore = 0;
    Image x;
    Image o;
    Image xScaled;
    Image oScaled;

    public TicTacToeGUI () {
        game = new TicTacToe();
    }
    private JPanel addComponentsToFrame() {
        JPanel pane = new JPanel() {
            protected void paintComponent (Graphics g) {
                super.paintComponent(g);

                g.drawLine(126, 4, 126, 376);
                g.drawLine(252, 4, 252, 376);

                g.drawLine(4, 126, 376, 126);
                g.drawLine(4, 252, 376, 252);

            }
        };
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Border emptyBorder = BorderFactory.createEmptyBorder();

        JButton restartButton = new JButton("Reset Board");
        pane.setLayout(new GridBagLayout());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridButtons[i][j] = new JButton();
                gridButtons[i][j].addActionListener(this);
                gridButtons[i][j].setActionCommand("gridButton" + Integer.toString(i) + "," + Integer.toString(j));
                gridButtons[i][j].setBorder(emptyBorder);
                gridButtons[i][j].setPreferredSize(new Dimension(100, 100));
                gridButtons[i][j].setOpaque(false);
                gridButtons[i][j].setContentAreaFilled(false);
            }
        }

        restartButton.addActionListener(this);
        restartButton.setActionCommand("restart");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 0.5;
                c.weighty = 0.5;
                c.gridwidth = 1;
                c.insets = new Insets(8,8,8,8);
                c.gridx = j;
                c.gridy = i;
                pane.add(gridButtons[i][j], c);
            }
        }

        //restartButton
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.insets = new Insets(8,8,8,8);  //top padding
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 3;
        pane.add(restartButton, c);

        c.weightx = 0.4;
        c.weighty = 0.6;
        c.gridheight = 30;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 0;
        c.insets = new Insets(8, 0, 0, 0);
        informationBoard.setFont(new Font("Serif", Font.PLAIN, 20));
        pane.add(informationBoard, c);

        try {
            x = ImageIO.read(getClass().getResource("x.png"));
            o = ImageIO.read(getClass().getResource("o.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        xScaled =  x.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        oScaled =  o.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        return pane;
    }
    public void createAndShowGUI() {
        //copied from GridBagLayout Tutorial haHAA
        //Set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        frame.getContentPane().add(addComponentsToFrame());

        //Display the window.
        frame.setSize(380 , 456);
        frame.repaint();
        frame.setVisible(true);
    }
    public void actionPerformed (ActionEvent e) {
      String action = e.getActionCommand();
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              if (action.equals("gridButton" + Integer.toString(i) + "," + Integer.toString(j))) {
                  int [][] openSpaces = game.getOpenSpaces();
                  for (int m = 0; m < openSpaces.length; m++) {
                      if (openSpaces[m][0] == i && openSpaces[m][1] == j) {
                          game.makeAMove(i , j, turn);
                          if (turn == 1) {
                              gridButtons[i][j].setOpaque(true);
                              gridButtons[i][j].setIcon(new ImageIcon(xScaled));
                              turn = 2;
                          }
                          else if (turn == 2) {
                              gridButtons[i][j].setOpaque(true);
                              gridButtons[i][j].setIcon(new ImageIcon(oScaled));
                              turn = 1;
                          }
                          game.checkWin();
                      }
                  }

              }
          }
      }
      if (action.equals("restart")) {
          game.clearBoard();
          turn = 1;
          for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                  gridButtons[i][j].setIcon(null);
              }
          }
      }
    }
    public void playGame() {

        restartPrompt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        restartPrompt.setSize(100 , 100);
        restartPrompt.getContentPane().add(addComponentsToRestartPrompt());

        while (keepPlaying) {
            informationBoard.setText("    Score  X: " + XScore + "  O: " + OScore);

            if (game.getWinner() != 0) {
                if (game.getWinner() == 1) {
                    XScore++;
                }
                else if (game.getWinner() == 2) {
                    OScore++;
                }

                restartPrompt.pack();
                restartPrompt.setVisible(true);

                if (!keepPlaying) {
                    frame.dispose();
                }
                else {
                    game.clearBoard();
                    turn = 1;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            gridButtons[i][j].setIcon(null);
                        }
                    }
                }
            }
        }
    }
    public JPanel addComponentsToRestartPrompt() {
        JPanel restartPromptPanel = new JPanel();
        JLabel restartLabel = new JLabel("Restart?");
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");

        restartPromptPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restartPrompt.dispose();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                keepPlaying = false;
                restartPrompt.dispose();
            }
        });

        c.fill = GridBagConstraints.BOTH;
        c.ipady = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.insets = new Insets(5,5,5,5);  //top padding
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 1;
        restartPromptPanel.add(yes, c);

        c.gridx = 1;
        restartPromptPanel.add(no, c);

        c.gridx = 0;
        c.gridy = 0;
        restartPromptPanel.add(restartLabel, c);

        return restartPromptPanel;
    }
}

