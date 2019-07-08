package GameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CollectPanel extends JPanel {

    /** player icon for moving right **/
    private ImageIcon playerRight;

    /** player icon for moving left **/
    private ImageIcon playerLeft;

    /** player icon for moving up or down to left **/
    private ImageIcon playerJumpLeft;

    /** player icon for moving up or down to right**/
    private ImageIcon playerJumpRight;

    /** player icon standing left **/
    private ImageIcon playerStandingLeft;

    /** player icon standing right **/
    private ImageIcon playerStandingRight;

    /** coin icon **/
    private ImageIcon coinObject;

    /** square sizes **/
    private static final int SQUARE_SIZE = 100;

    /** scaled image size **/
    private static final int IMAGE_SIZE = 100;

    /** board **/
    private JButton[][] board;

    /** board panel **/
    private JPanel boardPanel;

    /** game class **/
    private Collect game;

    /***********************************************
     * Constructor for the game space.
     **********************************************/
    public CollectPanel() {
        // initialize game
        game = new Collect("Collect!");

        // initialize board
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(game.getBoardHeight(), game.getBoardWidth(), 1, 1));
        board = new JButton[game.getBoardWidth()][game.getBoardHeight()];

        // initialize icons
        initIcons();

        // draws the game panel
        drawBoard();

        // add panel to frame
        add(boardPanel, BorderLayout.CENTER);
        boardPanel.setPreferredSize(new Dimension(600, 600));
    }

    /***********************************************
     * Initializes all image icons.
     **********************************************/
    private void initIcons() {
        // coin icon
        coinObject = new ImageIcon(new ImageIcon("coin.jpg").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));

        // left/right icons
        playerLeft = new ImageIcon(new ImageIcon("left.png").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));
        playerRight = new ImageIcon(new ImageIcon("right.png").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));

        // up/down icons
        playerJumpLeft = new ImageIcon(new ImageIcon("jumpLeft.png").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));
        playerJumpRight = new ImageIcon(new ImageIcon("jumpRight.png").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));

        // standing icons
        playerStandingLeft = new ImageIcon(new ImageIcon("standingLeft.jpg").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));
        playerStandingRight = new ImageIcon(new ImageIcon("standingRight.jpg").getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_DEFAULT));
    }

    private void drawBoard() {
        System.out.println("Drawing board...");
        for (int r = 0; r < game.getBoardHeight(); r++) {
            for (int c = 0; c < game.getBoardWidth(); c++) {
                if (game.pieceAt(c, r) == SpaceType.EMPTY) {
                    board[c][r] = new JButton("", null);
                } else if (game.pieceAt(c, r) == SpaceType.COIN) {
                    board[c][r] = new JButton(null, coinObject);
                } else if (game.pieceAt(c, r) == SpaceType.PLAYER) {
                    board[c][r] = new JButton(null, pickIcon());
                }

                setBackGroundColor(c, r);
                boardPanel.add(board[c][r]);
            }
        }
    }

    /*************************************************************
     * Sets the color of a particular square on the board.
     *
     * @param r integer of row
     * @param c integer of column
     ************************************************************/
    private void setBackGroundColor(final int c, final int r) {
        if ((c % 2 == 1 && r % 2 == 0) || (c % 2 == 0 && r % 2 == 1)) {
            board[c][r].setBackground(Color.LIGHT_GRAY);
        } else if ((c % 2 == 0 && r % 2 == 0) || (c % 2 == 1 && r % 2 == 1)) {
            board[c][r].setBackground(Color.WHITE);
        }
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
}
