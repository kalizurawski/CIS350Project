package GameProject;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SpaceBoard extends JPanel implements Runnable, SpaceCommons {

    /** dimension. **/
    private Dimension d;
    /** list of aliens. **/
    private ArrayList<Aliens> aliens;
    /** declaration of player. **/
    private SpacePlayer player;
    /** declaration of shot. **/
    private Shot shot;

    /** alien starting x location. **/
    private final int ALIEN_INIT_X = 150;
    /** alien starting y location. **/
    private final int ALIEN_INIT_Y = 5;
    /** direction. **/
    private int direction = -1;
    /** number of deaths. **/
    private int deaths = 0;

    /** current number of lives remaining. **/
    private int lives = PLAYER_LIVES;

    /** current game status. **/
    private boolean inGame;
    /** declaration of explosion image. **/
    private final String expImg;
    /** game message. **/
    private String message;

    /** animation thread. **/
    private Thread animator;

    /***********************************************
     * Initialize space board.
     **********************************************/
    public SpaceBoard() {
        inGame = true;
        expImg = "explosion.png";
        message = "Game Over";

        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        setBackground(Color.black);

        gameInit();
        setDoubleBuffered(true);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        gameInit();
    }

    /***********************************************
     * Initializes game.
     **********************************************/
    public void gameInit() {
        aliens = new ArrayList<>();

        for (int i = 0; i < ALIEN_ROWS; i++) {
            for (int j = 0; j < ALIEN_COLS; j++) {
                Aliens alien = new Aliens(ALIEN_INIT_X + SPACE_BETWEEN_ALIENS * j, ALIEN_INIT_Y + SPACE_BETWEEN_ALIENS * i);
                aliens.add(alien);
            }
        }

        player = new SpacePlayer();
        shot = new Shot();

        if (animator == null || !inGame) {

            animator = new Thread(this);
            animator.start();
        }
    }

    /***********************************************
     * Draws aliens.
     * @param g graphics parameter
     **********************************************/
    public void drawAliens(Graphics g) {

        for (Aliens alien: aliens) {

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }

            if (alien.isDying()) {
                alien.die();
            }
        }
    }

    /***********************************************
     * Draws player.
     * @param g graphics parameter
     **********************************************/
    public void drawPlayer(Graphics g) {

        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        if (player.isDying()) {
            lives -= 1;     // decrease lives
            if (lives < 0) {
                player.die();
                inGame = false;
            } else {
                String playerImg = "warioSpace.png";
                ImageIcon ii = new ImageIcon(new ImageIcon(playerImg).getImage()
                        .getScaledInstance(PLAYER_WIDTH, PLAYER_HEIGHT,
                                Image.SCALE_DEFAULT));
                player.setImage(ii.getImage());
                player.setDying(false);
            }
        }
    }

    /***********************************************
     * Draws shots.
     * @param g graphics parameter
     **********************************************/
    public void drawShot(Graphics g) {

        if (shot.isVisible()) {
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    /***********************************************
     * Draws bombs/explosions.
     * @param g graphics parameter
     **********************************************/
    public void drawBombing(Graphics g) {
        // for each alien
        for (Aliens a : aliens) {
            Aliens.Bomb b = a.getBomb();

            // check if bomb is destroyed
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (inGame) {

            g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
            drawAliens(g);
            drawPlayer(g);
            drawShot(g);
            drawBombing(g);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void gameOver() {

        Graphics g = this.getGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, BOARD_WIDTH / 2 - 30, BOARD_WIDTH - 100, 50);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (BOARD_WIDTH - metr.stringWidth(message)) / 2,
                BOARD_WIDTH / 2);
    }

    /***********************************************
     * Cycles animations
     **********************************************/
    public void animationCycle() {

        // checks to see if all aliens are dead.
        if (deaths == NUMBER_OF_ALIENS_TO_DESTROY) {
            inGame = false;
            message = "Game won!";
        }

        // player
        player.act();

        // shot
        if (shot.isVisible()) {

            int shotX = shot.getX();
            int shotY = shot.getY();

            for (Aliens alien: aliens) {

                int alienX = alien.getX();
                int alienY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (alienX)
                            && shotX <= (alienX + ALIEN_WIDTH)
                            && shotY >= (alienY)
                            && shotY <= (alienY + ALIEN_HEIGHT)) {
                        ImageIcon ii = new ImageIcon(new ImageIcon(expImg).getImage()
                                .getScaledInstance(EXP_WIDTH, EXP_HEIGHT,
                                        Image.SCALE_DEFAULT));
                        alien.setImage(ii.getImage());
                        alien.setDying(true);
                        deaths++;
                        shot.die();
                    }
                }
            }

            int y = shot.getY();
            y -= SHOT_SPEED;

            if (y < 0) {
                shot.die();
            } else {
                shot.setY(y);
            }
        }

        // aliens

        for (Aliens alien: aliens) {
            int x = alien.getX();
            if (x >= BOARD_WIDTH - BORDER_RIGHT && direction != -1) {

                direction = -1;

                for (Aliens a2 : aliens) {
                    a2.setY(a2.getY() + GO_DOWN);
                }
            }

            if (x <= BORDER_LEFT && direction != 1) {

                direction = 1;

                for (Aliens a : aliens) {
                    a.setY(a.getY() + GO_DOWN);
                }
            }
        }

        // for each alien
        for (Aliens alien : aliens) {
            // if it is visible
            if (alien.isVisible()) {
                int y = alien.getY();

                if (y > GROUND - ALIEN_HEIGHT) {
                    inGame = false;
                    message = "Invasion!";
                }
                alien.act(direction);
            }
        }

        // bombs
        Random generator = new Random();

        for (Aliens alien: aliens) {

            int shot = generator.nextInt(CHANCE);
            Aliens.Bomb b = alien.getBomb();

            if (shot == 1 && alien.isVisible() && b.isDestroyed()) {

                b.setDestroyed(false);
                b.setX(alien.getX());
                b.setY(alien.getY());
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if (bombX >= (playerX)
                        && bombX <= (playerX + PLAYER_WIDTH)
                        && bombY <= (playerY)
                        && bombY >= (playerY - PLAYER_HEIGHT)) {
                    ImageIcon ii = new ImageIcon(new ImageIcon(expImg).getImage()
                            .getScaledInstance(PLAYER_WIDTH, PLAYER_HEIGHT, Image.SCALE_DEFAULT));
                    player.setImage(ii.getImage());
                    player.setDying(true);
                    b.setDestroyed(true);
                }
            }

            if (!b.isDestroyed()) {

                b.setY(b.getY() + 1);

                if (b.getY() >= GROUND - BOMB_HEIGHT) {
                    b.setDestroyed(true);
                }
            }
        }
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (inGame) {

            repaint();
            animationCycle();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            beforeTime = System.currentTimeMillis();
        }

        gameOver();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {

                if (inGame) {
                    if (!shot.isVisible()) {
                        shot = new Shot(x, y);
                    }
                }
            }
        }
    }
}
