package GameProject;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Shot extends SpaceSprite implements SpaceCommons {

    /** image for bullet. **/
    private static final String shotImg = "coinDark.jpg";
    /** horizontal space. **/
    private static final int H_SPACE = 6;
    /** vertical space. **/
    private static final int V_SPACE = 1;

    /***********************************************
     * Unused public shot initializer.
     **********************************************/
    public Shot() {
    }

    /***********************************************
     * Public shot initializer.
     * @param x horizontal position of shot
     * @param y vertical position of shot
     **********************************************/
    public Shot(final int x, final int y) {
        initShot(x, y);
    }

    /***********************************************
     * Initializes bullet shot.
     * @param x horizontal position of shot
     * @param y vertical position of shot
     **********************************************/
    private void initShot(final int x, final int y) {
        ImageIcon ii = new ImageIcon(new ImageIcon(shotImg).getImage()
                .getScaledInstance(BOMB_WIDTH, BOMB_HEIGHT, Image.SCALE_DEFAULT));
        setImage(ii.getImage());

        setX(x + H_SPACE);
        setY(y - V_SPACE);
    }
}
