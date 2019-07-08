package GameProject;

import java.awt.*;
import javax.swing.*;

/**************************************************
 * This class is used for all universal game panel
 * functions.
 **************************************************/
public class GamePanel extends JPanel {

    /** panel width **/
    private static final int WIDTH = 200;

    /** panel height **/
    private static final int HEIGHT = 500;

    /** panel for gameplay **/
    private JPanel gameSpace;

    /** panel for countdown **/
    private JPanel countdownSpace = new JPanel();

    /** bomb icon **/
    private ImageIcon bomb;

    /** fuse icon **/
    private ImageIcon fuse;

    /** text area for countdown **/
    private JLabel timeRemaining;

    /***********************************************
     * Constructor to put together board components
     *
     * @param minigame panel for gameplay
     **********************************************/
    public GamePanel(JPanel minigame) {
        gameSpace = minigame;
        formatCountdownSpace();
        addPanes();
    }

    private void formatCountdownSpace() {
        // set layout to gridbag
        countdownSpace.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        // add time remaining to upper left corner of pane
        timeRemaining = new JLabel(Integer.toString(5));
        countdownSpace.add(timeRemaining, c);

        // add bomb icon below time remaining
        c.gridy = 1;
        countdownSpace.add(new JLabel(bomb), c);

        // add fuse icon left of bomb spanning 6 cols
        c.gridx = 1;
        c.gridwidth = 6;
        countdownSpace.add(new JLabel(fuse), c);
    }

    private void addPanes() {
        setLayout(new BorderLayout());
        add(gameSpace, BorderLayout.CENTER);
        add(countdownSpace, BorderLayout.SOUTH);
    }

    private void updatePanel() {
        timeRemaining.setText(Integer.toString(5));
    }

}
