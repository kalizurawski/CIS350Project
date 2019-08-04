package GameProject;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;


/**************************************************
 * This class is used for all universal game panel
 * functions.
 **************************************************/
public class FusePanel extends JPanel {

    /** timer variable. **/
    private static final int TIMER_DELAY = 1000;

    /** scaled image size. **/
    private static final int IMAGE_SIZE = 100;

    /** scaled number height. **/
    private static final int NUM_HEIGHT = 75;

    /** scaled number width. **/
    private static final int NUM_WIDTH = 50;

    /** start time. **/
    private static final int START_TIME = 5;

    /** text area for countdown. **/
    private JLabel timeRemaining;

    /** timer definition. **/
    private transient Timer timer;

    /** timer task definition. **/
    private transient TimerTask task;

    /** bomb label. **/
    private JLabel bombSpot;

    /** bomb icon. **/
    private ImageIcon bomb;

    /** explosion icon. **/
    private ImageIcon explosion;

    /** number zero. **/
    private ImageIcon zero;

    /** number one. **/
    private ImageIcon one;

    /** number two. **/
    private ImageIcon two;

    /** number three. **/
    private ImageIcon three;

    /** number four. **/
    private ImageIcon four;

    /** number five. **/
    private ImageIcon five;

    /***********************************************
     * Constructor to put together board components.
     **********************************************/
    public FusePanel() {

        // init timer
        timer = new Timer();
        task = new Countdown();

        // init icons
        initIcons();

        // set layout to borderlayout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // set background
        setBackground(Color.BLACK);

        // add time remaining to upper left corner of pane
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        timeRemaining = new JLabel(getNumber(START_TIME));
        add(timeRemaining, c);

        // add bomb icon below time remaining
        c.gridy = 1;
        bombSpot = new JLabel(bomb);
        add(bombSpot, c);
    }

    /***********************************************
     * Starts timer.
     **********************************************/
    public void startTimer() {
        timer.schedule(task, TIMER_DELAY, TIMER_DELAY);
    }

    /***********************************************
     * Initializes the image icons.
     **********************************************/
    private void initIcons() {
        // bomb icon
        bomb = new ImageIcon(new ImageIcon("bomb.jpg").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));
        explosion = new ImageIcon(new ImageIcon("explosion.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        // count
        zero = new ImageIcon(new ImageIcon("zero.png").getImage()
                .getScaledInstance(NUM_WIDTH, NUM_HEIGHT,
                        Image.SCALE_DEFAULT));
        one = new ImageIcon(new ImageIcon("one.png").getImage()
                .getScaledInstance(NUM_WIDTH, NUM_HEIGHT,
                        Image.SCALE_DEFAULT));
        two = new ImageIcon(new ImageIcon("two.png").getImage()
                .getScaledInstance(NUM_WIDTH, NUM_HEIGHT,
                        Image.SCALE_DEFAULT));
        three = new ImageIcon(new ImageIcon("three.png").getImage()
                .getScaledInstance(NUM_WIDTH, NUM_HEIGHT,
                        Image.SCALE_DEFAULT));
        four = new ImageIcon(new ImageIcon("four.png").getImage()
                .getScaledInstance(NUM_WIDTH, NUM_HEIGHT,
                        Image.SCALE_DEFAULT));
        five = new ImageIcon(new ImageIcon("five.png").getImage()
                .getScaledInstance(NUM_WIDTH, NUM_HEIGHT,
                        Image.SCALE_DEFAULT));
    }

    /***********************************************
     * Get the countdown number.
     * @param num integer of image number
     * @return ImageIcon
     **********************************************/
    private ImageIcon getNumber(final int num) {
        switch (num) {
            case 0:
                return zero;
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            case 5:
                return five;
            default:
                return zero;
        }
    }

    /***********************************************
     * Inner fuse panel class for the countdown.
     **********************************************/
    class Countdown extends TimerTask {

        /** time game has in seconds. **/
        private int time = START_TIME;

        /***********************************************
         * Runs the clock.
         **********************************************/
        public void run() {
            // decreases time
            if (time > 0) {
                time--;
            } else {
                timer.cancel();
            }

            updatePanel();
        }

        /***********************************************
         * Updates the fuse panel.
         **********************************************/
        private void updatePanel() {
            // change time icon
            timeRemaining.setIcon(getNumber(time));

            // if time is zero change bomb to explosion
            if (time == 0) {
                bombSpot.setIcon(explosion);
            }
            repaint();
            System.out.println("Time: " + time);
        }
    }
}
