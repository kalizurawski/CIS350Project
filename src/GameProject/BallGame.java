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

public class BallGame extends JComponent implements ActionListener, MouseMotionListener, KeyListener {

    private int ballx = 150;
    private int bally = 30;
    private int paddlex = 0;
    private int ballySpeed = 7;
    private int ballxSpeed = 5;
    private int score = 0;
    private int round = 1;
    private int bounces = 0;
    private static int delay = 20;
    public boolean gameOver, started;

    public static void main(int round) {

        JFrame wind = new JFrame("RedBall/GamePinfo");
        BallGame g = new BallGame();
        wind.add(g);
        wind.pack();
        wind.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wind.setLocationRelativeTo(null);
        wind.setVisible(true);
        wind.addMouseMotionListener(g);

        //speed up the timer each round
        Timer tt = new Timer(delay, g);
        tt.start();

    }

    public void newball(int ballx, int bally, int ballxspeed, int ballyspeed) {

        ballx = 150;
        bally = 30;
        ballxspeed = 5;
        ballyspeed = 7;

        JOptionPane.showMessageDialog(null, "new ball !");

        return;
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {

        //draw the sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.GREEN);
        g.fillRect(0, 550, 800, 100);

        //draw the paddel
        g.setColor(Color.black);
        g.fillRect(paddlex, 500, 100, 20);

        //draw the ball
        g.setColor(Color.RED);
        g.fillOval(ballx, bally, 30, 30);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 8, 50));
        g.drawString(String.valueOf(score), 30, 80);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	//Manages ball movement
    	ballx = ballx + ballxSpeed;
        bally = bally + ballySpeed;

        if (gameOver) {
            
        	//displays the dialog box indicating victory
            JOptionPane.showMessageDialog(this, "You lost on round"
            		+ round + "!");
            
            //terminate the program upon acknowledgement of loss
            System.exit(0);
            
        }
        
        if (bounces==10) {
        	
        	//reset score
        	bounces = 0;
        	
        	round++;
        	
        	JOptionPane.showMessageDialog(this,"You Win! You move on to"
        			+ " round " + round + "!");
        	
        }
        	
        
        // Sets ball speed upward if it hits the paddle
        if (ballx >= paddlex && ballx <= paddlex + 100 && bally >= 475) {

            ballySpeed = -7 - (round*2);
            
            //monitors the number of times the ball is successfully hit
            score++;
            bounces++;

        }

        // Handles loss condition
        if (bally >= 500 ) {

            gameOver = true;

        }

        // Sets ball movement down if it hits the ceiling
        if (bally <= 0) {

            ballySpeed = 7 + (round*2);

        }

        // Sets ball
        if (ballx >= 775) {

            ballxSpeed = -5 - (round*2);

        }

        // Window left
        if (ballx <= 0) {

            ballxSpeed = 5 + (round*2);

        }

        //**********************************************************************
        
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    	//places paddle in middle of mouse
        paddlex = e.getX() - 50;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}


