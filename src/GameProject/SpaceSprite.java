package GameProject;

import java.awt.Image;

public class SpaceSprite {

    /** whether sprite is visible. **/
    private boolean visible;
    /** declaration of image. **/
    private Image image;
    /** sprite horizontal location. **/
    protected int x;
    /** sprite vertical location. **/
    protected int y;
    /** whether or not sprite is dying. **/
    protected boolean dying;
    /** movement. **/
    protected int dx;

    /***********************************************
     * Sprite initialization.
     **********************************************/
    public SpaceSprite() {
        visible = true;
    }

    /***********************************************
     * Sets sprite as dead and makes it invisible.
     **********************************************/
    public void die() {
        visible = false;
    }

    /***********************************************
     * Checks to see if sprite is visible.
     * @return whether or not sprite is visible
     **********************************************/
    public boolean isVisible() {
        return visible;
    }

    /***********************************************
     * Sets visibility of sprite.
     * @param spriteVis visibility of sprite
     **********************************************/
    public void setVisible(final boolean spriteVis) {
        this.visible = spriteVis;
    }

    /***********************************************
     * Sets the image for the sprite.
     * @param img sprite image
     **********************************************/
    public void setImage(final Image img) {
        this.image = img;
    }

    /***********************************************
     * Gets the image for the sprite.
     * @return returns image of sprite
     **********************************************/
    public Image getImage() {
        return image;
    }

    /***********************************************
     * Sets x location of sprite.
     * @param hz horizontal sprite location
     **********************************************/
    public void setX(final int hz) {
        this.x = hz;
    }

    /***********************************************
     * Sets x location of sprite.
     * @param vt horizontal sprite location
     **********************************************/
    public void setY(final int vt) {
        this.y = vt;
    }

    /***********************************************
     * Gets y location of sprite.
     * @return returns y location
     **********************************************/
    public int getY() {
        return y;
    }

    /***********************************************
     * Gets x location of sprite.
     * @return returns x location
     **********************************************/
    public int getX() {
        return x;
    }

    /***********************************************
     * Sets status of sprite.
     * @param status sprite life status
     **********************************************/
    public void setDying(final boolean status) {
        this.dying = status;
    }

    /***********************************************
     * Returns status of sprite.
     * @return sprite status
     **********************************************/
    public boolean isDying() {
        return this.dying;
    }
}
