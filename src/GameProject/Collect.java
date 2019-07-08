package GameProject;

import java.awt.event.*;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

/**************************************************
 * This class is used for all custom functionality
 * for the "Collect" game.
 **************************************************/
public class Collect extends Game implements KeyListener {

    /** height of board. **/
    private static final int BOARD_HEIGHT = 5;

    /** width of board. **/
    private static final int BOARD_WIDTH = 5;

    /** coin x location. **/
    private int coinX;

    /** coin y location. **/
    private int coinY;

    /** whether or not game is in play. **/
    private boolean inPlay;

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
        // super(word);

        // add key listener
        addKeyListener(this);

        // initialize all variables
        boardInit();
        playerInit();
        coinInit();
        super.setWin(false);
        inPlay = true;
    }

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

    private void playerInit() {
        // generates random location for player
        int x = rand.nextInt(BOARD_WIDTH);
        int y = rand.nextInt(BOARD_HEIGHT);
        player = new CollectPlayer(x, y, BOARD_WIDTH, BOARD_HEIGHT);

        // place player into board
        board[player.getCurrX()][ player.getCurrY()] = SpaceType.PLAYER;
    }

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

    private void checkWin() {
        if (coinX == player.getCurrX() && coinY == player.getCurrY()) {
            inPlay = false;         // take game out of play
            super.setWin(true);
        } else {
            super.setWin(false);
        }
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

    /***********************************************
     * Gets the height of the board.
     *
     * @return board height
     **********************************************/
    public int getBoardHeight() {
        return this.BOARD_HEIGHT;
    }

    /***********************************************
     * Gets the width of the board
     *
     * @return board width
     **********************************************/
    public int getBoardWidth() {
        return this.BOARD_WIDTH;
    }

    /** Handle the key typed event **/
    @Override
    public void keyTyped(final KeyEvent e) {
    }

    /** Handle the key pressed event **/
    @Override
    public void keyPressed(final KeyEvent e) {
        if (inPlay) {
            if (e.getKeyCode() == e.VK_RIGHT)
                player.moveRight();
            else if (e.getKeyCode() == e.VK_LEFT)
                player.moveLeft();
            else if (e.getKeyCode() == e.VK_UP)
                player.moveUp();
            else if (e.getKeyCode() == e.VK_DOWN)
                player.moveDown();

            checkWin();
        }
    }

    /** Handle the key released event **/
    @Override
    public void keyReleased(final KeyEvent e) {
    }


}
