package GameProject;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class SpacePlayer extends SpaceSprite implements SpaceCommons {

    /** starting y position of player. **/
    private final int START_Y = 280;
    /** starting x position of player. **/
    private final int START_X = 270;
    /** movement amount of player. **/
    private final int MVMT_AMT = 2;
    /** player image declaration. **/
    private final String playerImg;
    /** player width. **/
    private int width;

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
     **********************************************/
    public void keyPressed(KeyEvent e) {
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
     **********************************************/
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
