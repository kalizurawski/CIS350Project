package GameProject;

import javax.swing.ImageIcon;
import java.awt.*;

public class Aliens extends SpaceSprite implements SpaceCommons {

    /** bomb declaration. **/
    private Bomb bomb;
    /** alien image. **/
    private final String alienImg;

    /***********************************************
     * Alien class initializer.
     * @param x horizontal location of alien
     * @param y vertical location of alien
     **********************************************/
    public Aliens(final int x, final int y) {
        alienImg = "goombaSpace.png";
        this.x = x;
        this.y = y;
        bomb = new Bomb(x, y);
        ImageIcon ii = new ImageIcon(new ImageIcon(alienImg).getImage()
                .getScaledInstance(ALIEN_WIDTH, ALIEN_HEIGHT,
                        Image.SCALE_DEFAULT));
        setImage(ii.getImage());
    }

    /***********************************************
     * Moves alien in given direction.
     * @param direction dir to move alien
     **********************************************/
    public void act(final int direction) {
        this.x += direction;
    }

    /***********************************************
     * Get bomb object.
     **********************************************/
    public Bomb getBomb() {
        return bomb;
    }

    /***********************************************
     * Defines the bomb class.
     **********************************************/
    public class Bomb extends SpaceSprite {

        /** bomb declaration. **/
        private final String bombImg;
        /** boolean of bomb status. **/
        private boolean destroyed;

        /***********************************************
         * Bomb initializer.
         * @param x horizontal bomb location
         * @param y vertical bomb location
         **********************************************/
        public Bomb(final int x, final int y) {
            bombImg = "bomb.jpg";
            setDestroyed(true);
            this.x = x;
            this.y = y;
            ImageIcon ii = new ImageIcon(new ImageIcon(bombImg).getImage()
                    .getScaledInstance(BOMB_WIDTH, BOMB_HEIGHT, Image.SCALE_DEFAULT));
            setImage(ii.getImage());
        }

        /***********************************************
         * Sets if bomb is destroyed or not.
         * @param bombStatus status of bomb
         **********************************************/
        public void setDestroyed(final boolean bombStatus) {
            this.destroyed = bombStatus;
        }

        /***********************************************
         * Sets if bomb is destroyed or not.
         * @return status of bomb
         **********************************************/
        public boolean isDestroyed() {
            return destroyed;
        }
    }
}