package WarioWareTests;

import GameProject.MemoryBoard;
import org.junit.Test;
import javax.swing.JFrame;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;

/******************************************************************
 * Tests the Memory Game Classes.
 *****************************************************************/
public class MemoryTest {

    /** Launch delay on the GUI. **/
    private static final int GUI_LAUNCH_DELAY = 5000;

    /** X axis mouse offset when AI moves to next button. **/
    private static final int X_MOUSE_OFFSET = 100;

    /** Y axis mouse offset when AI moves to next button. **/
    private static final int Y_MOUSE_OFFSET = 125;

    /** Starting coordinate for AI cycle. **/
    private static final int INITIAL_COORDINATE = 100;

    /** Number of cards on the X axis of the board. **/
    private static final int CARDS_WIDE = 5;

    /** Number of cards on the Y axis of the board. **/
    private static final int CARDS_TALL = 4;

    /** Width of the memory board GUI. **/
    private static final int MEMORY_BOARD_WIDTH = 500;

    /** Height of the memory board GUI. **/
    private static final int MEMORY_BOARD_HEIGHT = 500;

    /** X coordinate where the memory board GUI will be placed. **/
    private static final int MEMORY_BOARD_X = 50;

    /** Y coordinate where the memory board GUI will be placed. **/
    private static final int MEMORY_BOARD_Y = 50;

    /******************************************************************
     * Tests the Memory Game Classes (MemoryBoard and MemoryCard)
     * by enabling an AI to play the game to completion.
     *
     * @throws AWTException thrown
     * @throws InterruptedException thrown
     *****************************************************************/

    @Test
    public void gameTest() throws AWTException, InterruptedException {

        MemoryBoard b = new MemoryBoard();

        b.setPreferredSize(new Dimension(MEMORY_BOARD_WIDTH,
                MEMORY_BOARD_HEIGHT));
        b.setLocation(MEMORY_BOARD_X, MEMORY_BOARD_Y);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
        Thread.sleep(GUI_LAUNCH_DELAY);

        Robot bot = new Robot();

        for (int l = 0; l < CARDS_TALL; l++) {
            for (int k = 0; k < CARDS_WIDE; k++) {
                for (int i = 0; i < CARDS_TALL; i++) {
                    for (int j = 0; j < CARDS_WIDE; j++) {

                        if (b.isGameWon()) {
                            break;
                        }

                        Thread.sleep(2);
                        bot.mouseMove(INITIAL_COORDINATE + (k * X_MOUSE_OFFSET),
                                INITIAL_COORDINATE + (l * Y_MOUSE_OFFSET));
                        Thread.sleep(2);
                        bot.mousePress(InputEvent.BUTTON1_MASK);
                        Thread.sleep(2);
                        bot.mouseRelease(InputEvent.BUTTON1_MASK);

                        Thread.sleep(2);
                        bot.mouseMove(INITIAL_COORDINATE + (j * X_MOUSE_OFFSET),
                                INITIAL_COORDINATE + (i * Y_MOUSE_OFFSET));
                        Thread.sleep(2);
                        bot.mousePress(InputEvent.BUTTON1_MASK);
                        Thread.sleep(2);
                        bot.mouseRelease(InputEvent.BUTTON1_MASK);

                        }
                    }
                }
            }
        }
	}