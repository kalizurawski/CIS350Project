package GameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class CollectPanel extends JPanel implements KeyListener {

    /** player icon for moving up or down to left. **/
    private ImageIcon playerJumpLeft;

    /** player icon for moving up or down to right. **/
    private ImageIcon playerJumpRight;

    /** player icon standing left. **/
    private ImageIcon playerStandingLeft;

    /** player icon standing right. **/
    private ImageIcon playerStandingRight;

    /** coin icon. **/
    private ImageIcon coinObject;

    /** whether or not game is in play. **/
    private boolean inPlay;

    /** game size. **/
    private static final int GAME_SIZE = 500;

    /** scaled image size. **/
    private static final int IMAGE_SIZE = 100;

    /** board. **/
    private JButton[][] board;

    /** board panel. **/
    private JPanel boardPanel;

    /** game class. **/
    private Collect game;

    /** bomb/fuse panel. **/
    private FusePanel fusePanel;

    /***********************************************
     * Constructor for the game space.
     **********************************************/
    public CollectPanel() {
        // initialize game
        game = new Collect("Collect!");
        inPlay = true;

        // initialize fuse panel
        fusePanel = new FusePanel();

        // initialize board
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(game.getBoardHeight(),
                game.getBoardWidth(), 1, 1));
        board = new JButton[game.getBoardWidth()][game.getBoardHeight()];

        // initialize icons
        initIcons();

        // initializes board
        initBoard();

        // add key listener
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // add panel to frame
        add(fusePanel, BorderLayout.SOUTH);
        add(boardPanel, BorderLayout.NORTH);
       // boardPanel.setPreferredSize(new Dimension(GAME_SIZE, GAME_SIZE));
    }

    /***********************************************
     * Initializes all image icons.
     **********************************************/
    private void initIcons() {
        // coin icon
        coinObject = new ImageIcon(new ImageIcon("coin.jpg").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        // up/down icons
        playerJumpLeft = new ImageIcon(new ImageIcon("jumpLeft.png")
                .getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));

        playerJumpRight = new ImageIcon(new ImageIcon("jumpRight.png")
                .getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));

        // standing icons
        playerStandingLeft = new ImageIcon(new ImageIcon("standingLeft.jpg").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));
        playerStandingRight = new ImageIcon(new ImageIcon("standingRight.jpg").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));
    }

    /***********************************************
     * Initializes the board.
     **********************************************/
    private void initBoard() {
        System.out.println("Initializing board...");
        for (int r = 0; r < game.getBoardHeight(); r++) {
            for (int c = 0; c < game.getBoardWidth(); c++) {
                if (game.pieceAt(c, r) == SpaceType.EMPTY) {
                    board[c][r] = new JButton("", null);
                } else if (game.pieceAt(c, r) == SpaceType.COIN) {
                    board[c][r] = new JButton(null, coinObject);
                } else if (game.pieceAt(c, r) == SpaceType.PLAYER) {
                    board[c][r] = new JButton(null, pickIcon());
                }

                board[c][r].setBackground(Color.WHITE);
                boardPanel.add(board[c][r]);
            }
        }
    }

    /***********************************************
     * Displays board to the player.
     **********************************************/
    private void displayBoard() {
        for (int r = 0; r < game.getBoardHeight(); r++) {
            for (int c = 0; c < game.getBoardWidth(); c++) {
                if (game.pieceAt(c, r) == SpaceType.EMPTY) {
                    board[c][r].setIcon(null);
                } else if (game.pieceAt(c, r) == SpaceType.PLAYER) {
                    board[c][r].setIcon(pickIcon());
                } else if (game.pieceAt(c, r) == SpaceType.COIN) {
                    board[c][r].setIcon(coinObject);
                }
            }
        }
        repaint();
    }

    /***********************************************
     * Determines icon to user when player moves.
     *
     * @return icon of player
     **********************************************/
    private ImageIcon pickIcon() {
        // get player directions and vertical
        Directions vertical = game.getPlayerVertical();
        Directions direction = game.getPlayerDirection();

        switch (vertical) {
            case UP:
                if (direction == Directions.LEFT) {
                    return playerJumpLeft;
                } else {
                    return playerJumpRight;
                }
            case DOWN:
                if (direction == Directions.LEFT) {
                    return playerJumpLeft;
                } else {
                        return playerJumpRight;
                }
            case NONE:
                if (direction == Directions.LEFT) {
                    return playerStandingLeft;
                } else {
                    return playerStandingRight;
                }
            default:
                return playerStandingLeft;
        }
    }

    /***********************************************
     * Key listener for keyPressed event.
     *
     * @param e key event
     **********************************************/
    public void keyPressed(final KeyEvent e) {
    }

    /***********************************************
     * Key listener for keyReleased event.
     *
     * @param e key event
     **********************************************/
    public void keyReleased(final KeyEvent e) {
    }

    /***********************************************
     * Key listener for keyTyped event.
     *
     * @param e key event
     **********************************************/
    public void keyTyped(final KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            game.moveRight();
        } else if (e.getKeyChar() == 'a') {
            game.moveLeft();
        } else if (e.getKeyChar() == 'w') {
            game.moveUp();
        } else if (e.getKeyChar() == 's') {
            game.moveDown();
        }
        displayBoard();

        // if this level is complete
        if (game.checkWin()) {
            System.out.println("Level fin.");
        }
    }
}