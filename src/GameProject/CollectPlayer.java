package GameProject;

/**************************************************
 * This class is used in conjuction with the Collect
 * class and operates as the player piece.
 **************************************************/
public class CollectPlayer {

    /** current x location. **/
    private int currX;

    /** current y location. **/
    private int currY;

    /** maximum x value. **/
    private int maxX;

    /** maximum y value. **/
    private int maxY;

    /** direction they are facing. **/
    private Directions direction;

    /** vertical direction of movement. **/
    private Directions vertical;

    /***********************************************
     * Initializes object of the CollectPlayer class.
     *
     * @param x is the x location of the player
     * @param y is the y location of the player
     * @param mx is the width of the board
     * @param my is the height of the board
     **********************************************/
    public CollectPlayer(final int x, final int y, final int mx, final int my) {
        this.currX = x;
        this.currY = y;
        this.maxX = mx;
        this.maxY = my;
        this.direction = Directions.LEFT;
        this.vertical = Directions.NONE;
    }

    /***********************************************
     * Moves the player piece right if valid.
     **********************************************/
    public void moveRight() {
        // if not at far right, move one to right
        if (currX != maxX - 1) {
            currX += 1;
        }
        direction = Directions.RIGHT;
        vertical = Directions.NONE;
        System.out.println("Player: " + currX + " " + currY);
    }

    /***********************************************
     * Moves the player piece left if valid.
     **********************************************/
    public void moveLeft() {
        // if not at far left, move one to left
        if (currX != 0) {
            currX -= 1;
        }
        direction = Directions.LEFT;
        vertical = Directions.NONE;
        System.out.println("Player: " + currX + " " + currY);
    }

    /***********************************************
     * Moves the player piece up if valid.
     **********************************************/
    public void moveUp() {
        // if not at top, move up
        if (currY != 0) {
            currY -= 1;
        }
        vertical = Directions.UP;
        System.out.println("Player: " + currX + " " + currY);
    }

    /***********************************************
     * Moves the player piece down if valid.
     **********************************************/
    public void moveDown() {
        // if not at bottom, move down
        if (currY != maxY - 1) {
            currY += 1;
        }
        vertical = Directions.DOWN;
        System.out.println("Player: " + currX + " " + currY);
    }

    /***********************************************
     * Gets the current x location of the player.
     *
     * @return player's current x location
     **********************************************/
    public int getCurrX() {
        return this.currX;
    }

    /***********************************************
     * Set the current x location of the player.
     *
     * @param x player's current x location
     **********************************************/
    public void setCurrX(final int x) {
        this.currX = x;
    }

    /***********************************************
     * Gets the current y location of the player.
     *
     * @return player's current y location
     **********************************************/
    public int getCurrY() {
        return this.currY;
    }

    /***********************************************
     * Set the current y location of the player.
     *
     * @param y player's current y location
     **********************************************/
    public void setCurrY(final int y) {
        this.currY = y;
    }

    /***********************************************
     * Gets the direction of the player.
     *
     * @return player's current direction
     **********************************************/
    public Directions getDirection() {
        return this.direction;
    }

    /***********************************************
     * Gets the current vertical of the player.
     *
     * @return player's current vertical
     **********************************************/
    public Directions getVertical() {
        return this.vertical;
    }
}
