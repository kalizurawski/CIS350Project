package GameProject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Collect extends Game implements KeyListener {

    /** height of board **/
    private static final int BOARD_HEIGHT = 5;

    /** width of board **/
    private static final int BOARD_WIDTH = 5;

    /** coin location **/
    private int coinX;
    private int coinY;

    /** possible board piece types **/
    private static final int EMPTY = 0;
    private static final int COIN = 1;
    private static final int PLAYER = 2;

    /** whether or not game is in play **/
    private boolean inPlay;

    /** random number generator **/
    Random rand = new Random();

    /** board array **/
    private static int[][] board;

    /** player class **/
    Collect_Player player;


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
        board_init();
        player_init();
        coin_init();
        super.setWin(false);
        inPlay = true;
    }

    private void board_init() {
        // initialize board array
        board = new int[BOARD_WIDTH][BOARD_HEIGHT];

        // initialize all spaces to empty
        for (int w = 0; w < BOARD_WIDTH; w++)
            for (int h = 0; h < BOARD_HEIGHT; h++)
                board[w][h] = EMPTY;
    }

    private void player_init() {
        // generates random location for player
        int x = rand.nextInt(BOARD_WIDTH);
        int y = rand.nextInt(BOARD_HEIGHT);
        player = new Collect_Player(x, y, BOARD_WIDTH, BOARD_HEIGHT);

        // place player into board
        board[player.getCurrX()][ player.getCurrY()] = PLAYER;
    }

    private void coin_init() {
        coinX = player.getCurrX();
        coinY = player.getCurrY();

        // generates random location for coin
        // Note: x and y must be different from player
        while(coinX == player.getCurrX()) {
            coinX = rand.nextInt(BOARD_WIDTH);
        }
        while(coinY == player.getCurrY()) {
            coinY = rand.nextInt(BOARD_HEIGHT);
        }

        // place coin into board
        board[coinX][coinY] = COIN;

    }

    private void check_win() {
        if (coinX == player.getCurrX() && coinY == player.getCurrY()) {
            inPlay = false;         // take game out of play
            super.setWin(true);
        }
        else
            super.setWin(false);
    }

    /** Handle the key typed event **/
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /** Handle the key pressed event **/
    @Override
    public void keyPressed(KeyEvent e) {
        if(inPlay) {
            if (e.getKeyCode() == e.VK_RIGHT)
                player.moveRight();
            else if (e.getKeyCode() == e.VK_LEFT)
                player.moveLeft();
            else if (e.getKeyCode() == e.VK_UP)
                player.moveUp();
            else if (e.getKeyCode() == e.VK_DOWN)
                player.moveDown();

            check_win();
        }
    }

    /** Handle the key released event **/
    @Override
    public void keyReleased(KeyEvent e) {
    }


}
