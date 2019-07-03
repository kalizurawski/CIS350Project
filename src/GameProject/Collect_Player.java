package GameProject;

public class Collect_Player {

    /** current x location **/
    private int currX;

    /** current y location **/
    private int currY;

    /** maximum x value **/
    private int maxX;

    /** maximum y value **/
    private int maxY;

    /***********************************************
     * Initializes object of the Collect_Player class.
     *
     * @param x is the x location of the player
     * @param y is the y location of the player
     * @param maxX is the width of the board
     * @param maxY is the height of the board
     **********************************************/
    public Collect_Player(int x, int y, int maxX, int maxY) {
        this.currX = x;
        this.currY = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /***********************************************
     * Moves the player piece right if valid
     **********************************************/
    public void moveRight() {
        // if not at far right, move one to right
        if (currX != maxX)
            currX += 1;
    }

    /***********************************************
     * Moves the player piece left if valid
     **********************************************/
    public void moveLeft() {
        // if not at far left, move one to left
        if (currX != 0)
            currX -= 1;
    }

    /***********************************************
     * Moves the player piece up if valid
     **********************************************/
    public void moveUp() {
        // if not at top, move up
        if (currY != maxY)
            currY += 1;
    }

    /***********************************************
     * Moves the player piece down if valid
     **********************************************/
    public void moveDown() {
        // if not at bottom, move down
        if (currY != 0)
            currY -= 1;
    }

    /***********************************************
     * Gets the current x location of the player
     *
     * @return player's current x location
     **********************************************/
    public int getCurrX() {
        return this.currX;
    }

    /***********************************************
     * Set the current x location of the player
     *
     * @param x player's current x location
     **********************************************/
    public void setCurrX(int x) {
        this.currX = x;
    }

    /***********************************************
     * Gets the current y location of the player
     *
     * @return player's current y location
     **********************************************/
    public int getCurrY() {
        return this.currY;
    }

    /***********************************************
     * Set the current y location of the player
     *
     * @param y player's current y location
     **********************************************/
    public void setCurrY(int y) {
        this.currX = y;
    }
}
