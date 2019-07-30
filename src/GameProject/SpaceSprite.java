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
    protected void setVisible(boolean spriteVis) {
        this.visible = spriteVis;
    }

    /***********************************************
     * Sets the image for the sprite.
     * @param image sprite image
     **********************************************/
    public void setImage(Image image) {
        this.image = image;
    }

    /***********************************************
     * Gets the image for the sprite.
     **********************************************/
    public Image getImage() {
        return image;
    }

    /***********************************************
     * Sets x location of sprite.
     * @param x horizontal sprite location
     **********************************************/
    public void setX(final int x) {
        this.x = x;
    }

    /***********************************************
     * Sets x location of sprite.
     * @param y horizontal sprite location
     **********************************************/
    public void setY(final int y) {
        this.y = y;
    }

    /***********************************************
     * Gets y location of sprite.
     **********************************************/
    public int getY() {
        return y;
    }

    /***********************************************
     * Gets x location of sprite.
     **********************************************/
    public int getX() {
        return x;
    }

    /***********************************************
     * Sets status of sprite.
     * @param status sprite life status
     **********************************************/
    public void setDying(boolean status) {
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