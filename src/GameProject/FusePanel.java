package GameProject;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;


/**************************************************
 * This class is used for all universal game panel
 * functions.
 **************************************************/
public class FusePanel extends JPanel{

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

    /** fuse width. **/
    private static final int FUSE_WIDTH = IMAGE_SIZE;

    /** fuse length. **/
    private int fuseLength = 301;

    /** fuse length difference. **/
    private static final int FUSE_DIFF = 70;

    /** text area for countdown. **/
    private JLabel timeRemaining;

    /** timer definition. **/
    private Timer timer;

    /** timer task definition. **/
    private TimerTask task;

    /** bomb label. **/
    private JLabel bombSpot;

    /** bomb icon. **/
    private ImageIcon bomb;

    /** fuse label. **/
    private JLabel fuseSpot;

    /** fuse icon. **/
    private ImageIcon fuse;

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

        // draw fuse
        c.gridy = 2;
        c.gridheight = FUSE_DIFF * 5;
        fuseSpot = new JLabel(fuse);
        add(fuseSpot, c);
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
        // fuse
        fuse = new ImageIcon(new ImageIcon("fuse.png").getImage()
                .getScaledInstance(FUSE_WIDTH, fuseLength,
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

            // change fuse length
            if (fuseLength >= FUSE_DIFF) {
                fuseLength -= FUSE_DIFF;
            }
            fuse = new ImageIcon(new ImageIcon("fuse.png").getImage()
                    .getScaledInstance(FUSE_WIDTH, fuseLength,
                            Image.SCALE_DEFAULT));
            fuseSpot.setIcon(fuse);

            // if time is zero change bomb to explosion
            if (time == 0) {
                bombSpot.setIcon(explosion);
            }
            repaint();
            System.out.println("Time: " + time);
        }
    }
}
