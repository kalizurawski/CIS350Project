package GameProject;

import java.awt.*;
import javax.swing.*;

/**************************************************
 * This class is used for all universal game panel
 * functions.
 **************************************************/
public class FusePanel extends JPanel {

    /** panel width. **/
    private static final int WIDTH = 500;

    /** panel height. **/
    private static final int HEIGHT = 100;

    /** scaled image size. **/
    private static final int IMAGE_SIZE = 100;

    /** bomb icon. **/
    private ImageIcon bomb;

    /** fuse icon. **/
    private ImageIcon fuse;

    /** text area for countdown. **/
    private JLabel timeRemaining;

    /** time remaining. **/
    private int time;

    /***********************************************
     * Constructor to put together board components.
     **********************************************/
    public FusePanel() {
        // set panel size
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // init icons
        initIcons();

        // set layout to gridbag
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        // add time remaining to upper left corner of pane
        timeRemaining = new JLabel(Integer.toString(5));
        add(timeRemaining, c);

        // add bomb icon below time remaining
        c.gridy = 1;
        add(new JLabel(bomb), c);

//        // add fuse icon left of bomb spanning 6 cols
//        c.gridx = 1;
//        c.gridwidth = 6;
//        add(new JLabel(fuse), c);
    }

    private void initIcons() {
        // bomb icon
        bomb = new ImageIcon(new ImageIcon("bomb.jpg").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));
    }

    private void updatePanel() {
        timeRemaining.setText(Integer.toString(time));
    }

}
