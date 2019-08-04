package GameProject;

import java.util.Random;

/**************************************************
 * This class is used for all custom functionality
 * for the "Collect" game.
 **************************************************/
public class Collect {

    /** height of board. **/
    public static final int BOARD_HEIGHT = 5;

    /** width of board. **/
    public static final int BOARD_WIDTH = 5;

    /** amount of time for the level. **/
    private static final int INIT_TIME = 5;

    /** game win status. **/
    private boolean win;

    /** game over status. **/
    private boolean gameover;

    /** amount of time remaining. **/
    private int timeRemaining;

    /** coin x location. **/
    private int coinX;

    /** coin y location. **/
    private int coinY;

    /** random number generator. **/
    private Random rand = new Random();

    /** board array. **/
    private static SpaceType[][] board;

    /** player class. **/
    private CollectPlayer player;

    /***********************************************
     * Initializes object of the Collect class.
     *
     * @param word used at the start of the game
     **********************************************/
    public Collect(final String word) {
        // initialize all variables
        boardInit();
        playerInit();
        coinInit();
        setGameOver(false);
        setWin(false);
        setTimeRemaining(INIT_TIME);
    }

    /***********************************************
     * Initializes board.
     **********************************************/
    private void boardInit() {
        System.out.println("Initializing board...");
        // initialize board array
        board = new SpaceType[BOARD_WIDTH][BOARD_HEIGHT];

        // initialize all spaces to empty
        for (int w = 0; w < BOARD_WIDTH; w++) {
            for (int h = 0; h < BOARD_HEIGHT; h++) {
                board[w][h] = SpaceType.EMPTY;
            }
        }
    }

    /***********************************************
     * Initializes player placement.
     **********************************************/
    private void playerInit() {
        // generates random location for player
        int x = rand.nextInt(BOARD_WIDTH);
        int y = rand.nextInt(BOARD_HEIGHT);
        player = new CollectPlayer(x, y, BOARD_WIDTH, BOARD_HEIGHT);

        // place player into board
        board[player.getCurrX()][ player.getCurrY()] = SpaceType.PLAYER;
    }

    /***********************************************
     * Initializes coin placement.
     **********************************************/
    private void coinInit() {
        coinX = player.getCurrX();
        coinY = player.getCurrY();

        // generates random location for coin
        // Note: x and y must be different from player
        while (coinX == player.getCurrX()) {
            coinX = rand.nextInt(BOARD_WIDTH);
        }
        while (coinY == player.getCurrY()) {
            coinY = rand.nextInt(BOARD_HEIGHT);
        }

        // place coin into board
        board[coinX][coinY] = SpaceType.COIN;
    }

    /***********************************************
     * Moves player left one space.
     **********************************************/
    public void moveLeft() {
        // get old spot
        int x = player.getCurrX();
        int y = player.getCurrY();

        // move player
        player.moveLeft();

        // update board
        board[x][y] = SpaceType.EMPTY;
        board[player.getCurrX()][ player.getCurrY()] = SpaceType.PLAYER;
    }

    /***********************************************
     * Moves player right one space.
     **********************************************/
    public void moveRight() {
        // get old spot
        int x = player.getCurrX();
        int y = player.getCurrY();

        // move player
        player.moveRight();

        // update board
        board[x][y] = SpaceType.EMPTY;
        board[player.getCurrX()][ player.getCurrY()] = SpaceType.PLAYER;
    }

    /***********************************************
     * Moves player up one space.
     **********************************************/
    public void moveUp() {
        // get old spot
        int x = player.getCurrX();
        int y = player.getCurrY();

        // move player
        player.moveUp();

        // update board
        board[x][y] = SpaceType.EMPTY;
        board[player.getCurrX()][ player.getCurrY()] = SpaceType.PLAYER;
    }

    /***********************************************
     * Moves player down one space.
     **********************************************/
    public void moveDown() {
        // get old spot
        int x = player.getCurrX();
        int y = player.getCurrY();

        // move player
        player.moveDown();

        // update board
        board[x][y] = SpaceType.EMPTY;
        board[player.getCurrX()][ player.getCurrY()] = SpaceType.PLAYER;
    }

    /***********************************************
     * This function is for testing purposes only.
     **********************************************/
    public void forceWin() {
        player.setCurrX(1);
        player.setCurrY(1);
        coinX = 1;
        coinY = 1;
    }

    /***********************************************
     * Checks to see if the level has been won.
     *
     * @return if the player has won the game
     **********************************************/
    public boolean checkWin() {
        if (coinX == player.getCurrX() && coinY == player.getCurrY()) {
            setWin(true);
        } else {
            setWin(false);
        }
        return this.win;
    }

    /***********************************************
     * Checks to see if game is over and should be
     * sent back to the menu screen.
     *
     * @return boolean of game status
     **********************************************/
    public boolean checkGameOver() {
        if (checkWin()) {
            setGameOver(true);
        } else if (timeRemaining == 0) {
            setGameOver(true);
        } else {
            setGameOver(false);
        }
        return this.gameover;
    }

    /***********************************************
     * Sets whether or not the level has been won.
     *
     * @param status level win status
     **********************************************/
    private void setWin(final boolean status) {
        this.win = status;
    }

    /***********************************************
     * Sets whether or not the game is over.
     *
     * @param status gameover status
     **********************************************/
    private void setGameOver(final boolean status) {
        this.gameover = status;
    }

    /***********************************************
     * Sets the time remaining in the level.
     *
     * @param time remaining time
     * @return time remaining (testing only)
     **********************************************/
    public int setTimeRemaining(final int time) {
        this.timeRemaining = time;
        return time;
    }

    /***********************************************
     * Gets the piece at a given row and column.
     *
     * @param col column of space
     * @param row row of space
     * @return piece type
     **********************************************/
    public SpaceType pieceAt(final int col, final int row) {
        return board[col][row];
    }

    /***********************************************
     * Gets the up/down the player is facing.
     *
     * @return player vertical
     **********************************************/
    public Directions getPlayerVertical() {
        return player.getVertical();
    }

    /***********************************************
     * Gets the direction the player is facing.
     *
     * @return player direction
     **********************************************/
    public Directions getPlayerDirection() {
        return player.getDirection();
    }
}
