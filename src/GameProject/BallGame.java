package GameProject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public final class BallGame extends JComponent
        implements ActionListener, MouseMotionListener, KeyListener {

    /** timer delay. **/
    private static final int DELAY = 20;
    /** ball y speed var. **/
    private static final int  BALL_Y_SPEED = 7;
    /** ball x speed var. **/
    private static final int BALL_X_SPEED = 5;
    /** ball x starting location. **/
    private static final int BALL_X_START = 150;
    /** ball y starting location. **/
    private static final int BALL_Y_START = 30;
    /** sky width. **/
    private static final int SKY_WIDTH = 800;
    /** sky height. **/
    private static final int SKY_HEIGHT = 600;
    /** grass width. **/
    private static final int GRASS_WIDTH = 800;
    /** grass height. **/
    private static final int GRASS_HEIGHT = 100;
    /** grass starting loc. **/
    private static final int GRASS_LOC = 550;
    /** ball dimension. **/
    private static final int BALL_DIMENSION = 30;
    /** paddle width. **/
    private static final int PADDLE_WIDTH = 100;
    /** paddle height. **/
    private static final int PADDLE_HEIGHT = 20;
    /** paddle location. **/
    private static final int PADDLE_LOC = 500;
    /** font size. **/
    private static final int FONT_SIZE = 50;
    /** font style. **/
    private static final int FONT_STYLE = 8;
    /** x coordinate for score print. **/
    private static final int STRING_X = 30;
    /** y coordinate for score ptint. **/
    private static final int STRING_Y = 80;
    /** number of bounces that make up a round. **/
    private static final int BOUNCE_ROUND = 10;
    /** The number 25. **/
    private static final int TWENTY_FIVE = 25;
    /** The number 50. **/
    private static final int FIFTY = 50;
    /** Loss barrier coordinate. **/
    private static final int LOSS_BARRIER = 500;
    /** coordinate of the rght wall of the GUI. **/
    private static final int RIGHT_WALL = 775;


    /** ball x location. **/
    private int ballx = BALL_X_START;
    /** ball y location. **/
    private int bally = BALL_Y_START;
    /** paddle x location. **/
    private int paddlex = 0;

    /** speed of ball Y. **/
    private int ballySpeed = BALL_Y_SPEED;
    /** speed of ball X. **/
    private int ballxSpeed = BALL_X_SPEED;
    /** current score. **/
    private int score = 0;
    /** current round. **/
    private int round = 1;
    /** current number of bounces. **/
    private int bounces = 0;

    /*********************************************
     * Starts Game.
     * @param round game round
     ********************************************/
    public static void main(final int round) {

         gameMake(round);

    }

    /*********************************************
     * Makes game.
     * @param round game round
     ********************************************/
    public static void gameMake(final int round) {
        JFrame wind = new JFrame("Ball Bounce");
        BallGame g = new BallGame();
        wind.add(g);
        wind.pack();
        wind.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wind.setLocationRelativeTo(null);
        wind.setVisible(true);
        wind.addMouseMotionListener(g);
        wind.dispose();

        //speed up the timer each round
        Timer tt = new Timer(DELAY, g);
        tt.start();
    }

    /*********************************************
     * Creates new ball.
     ********************************************/
    public void newball() {

        this.ballx = BALL_X_START;
        this.bally = BALL_Y_START;
        this.ballxSpeed = BALL_X_SPEED;
        this.ballySpeed = BALL_Y_SPEED;

        JOptionPane.showMessageDialog(null, "new ball !");
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(SKY_WIDTH, SKY_HEIGHT);
    }

    @Override
    protected void paintComponent(final Graphics g) {

        //draw the sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, SKY_WIDTH, SKY_HEIGHT);
        g.setColor(Color.GREEN);
        g.fillRect(0, GRASS_LOC, GRASS_WIDTH, GRASS_HEIGHT);
        //draw the paddle
        g.setColor(Color.black);
        g.fillRect(paddlex, PADDLE_LOC, PADDLE_WIDTH, PADDLE_HEIGHT);
        //draw the ball
        g.setColor(Color.RED);
        g.fillOval(ballx, bally, BALL_DIMENSION, BALL_DIMENSION);
        // write score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", FONT_STYLE, FONT_SIZE));
        g.drawString(String.valueOf(score), STRING_X, STRING_Y);

    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        //Manages ball movement
        ballx += ballxSpeed;
        bally += ballySpeed;

        if (bounces == BOUNCE_ROUND) {

            //reset score
            bounces = 0;
            round++;
            JOptionPane.showMessageDialog(this, "You Win! You move on to"
                    + " round " + round + "!");

        } else if (ballx >= paddlex && ballx <= paddlex + PADDLE_WIDTH && bally >= (PADDLE_LOC - TWENTY_FIVE)) {
            // Sets ball speed upward if it hits the paddle
            ballySpeed = -BALL_Y_SPEED - (round * 2);
            //monitors the number of times the ball is successfully hit
            score++;
            bounces++;

        } else if (bally >= LOSS_BARRIER) {

            // Handles loss condition
            //displays the dialog box indicating victory
            JOptionPane.showMessageDialog(this, "You lost on round"
                    + round + "!");
            ballx = BALL_X_START;
            bally = BALL_Y_START;

            //terminate the program upon acknowledgement of loss
            System.exit(0);

        } else if (bally <= 0) {
            // Sets ball movement down if it hits the ceiling
            ballySpeed = BALL_Y_SPEED + (round * 2);
        } else if (ballx >= RIGHT_WALL) {
            // Sets ball
            ballxSpeed = -BALL_X_SPEED - (round * 2);
        } else if (ballx <= 0) {
            // Window left
            ballxSpeed = BALL_X_SPEED + (round * 2);
        }
        repaint();
    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        //places paddle in middle of mouse
        paddlex = e.getX() - FIFTY;
        repaint();
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }

}


