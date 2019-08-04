package GameProject;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class SpacePlayer extends SpaceSprite implements SpaceCommons {

    /** starting y position of player. **/
    private static final int START_Y = 280;
    /** starting x position of player. **/
    private static final int START_X = 270;
    /** movement amount of player. **/
    private static final int MVMT_AMT = 2;
    /** player image declaration. **/
    private final String playerImg;
    /** player width. **/
    private int width;

    /***********************************************
     * Instantiates class.
     **********************************************/
    public SpacePlayer() {
        playerImg = "warioSpace.png";

        ImageIcon ii = new ImageIcon(new ImageIcon(playerImg).getImage()
                .getScaledInstance(PLAYER_WIDTH, PLAYER_HEIGHT,
                        Image.SCALE_DEFAULT));

        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
        setX(START_X);
        setY(START_Y);
    }

    /***********************************************
     * Moves player.
     **********************************************/
    public void act() {
        x += dx;

        if (x <= 2) {
            x = 2;
        }

        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }
    }

    /***********************************************
     * Takes player input of left and right.
     * @param e entered key
     **********************************************/
    public void keyPressed(final KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -MVMT_AMT;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = MVMT_AMT;
        }
    }

    /***********************************************
     * Stops moving player when key is released.
     * @param e entered key
     **********************************************/
    public void keyReleased(final KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
