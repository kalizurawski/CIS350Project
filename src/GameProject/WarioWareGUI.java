/*****************************************************************
Operates the GUI of the main menu for Warioware 2.0, enabling
the user to select between two games: a coin collector game and
a memory match game.

@author Robert Gardner
@Coauthor Kali Zurawski
@version 1.0
 *****************************************************************/

package GameProject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/******************************************************************
 * Calls for initialization of icons, prepares the frame for the
 * GUI, and places the buttons in the frame. It also places the
 * images on the buttons
 *****************************************************************/
public class WarioWareGUI extends JFrame {

    /** Image Icon for one of the buttons. **/
    private ImageIcon thinkingMario;

    /** Adjusted size of images. **/
    private static final int IMAGE_SIZE = 100;

    /** The X coordinate where the gui will be placed. **/
    private static final int FRAME_X_LOCATION = 500;

    /** The Y coordinate where the gui will be placed. **/
    private static final int FRAME_Y_LOCATION = 250;

    /** The gui width. **/
    private static final int GUI_WIDTH = 500;

    /** The gui height. **/
    private static final int GUI_HEIGHT = 500;

    /** X coordinate where the coin game button will be placed. **/
    private static final int COIN_BUTTON_X = 275;

    /** Y coordinate where the coin game button will be placed. **/
    private static final int COIN_BUTTON_Y = 50;

    /** X coordinate where the memory game button will be placed. **/
    private static final int MEMORY_BUTTON_X = 50;

    /** Y coordinate where the memory game button will be placed. **/
    private static final int MEMORY_BUTTON_Y = 50;

    /** Width of buttons on the GUI. **/
    private static final int BUTTON_WIDTH = 150;

    /** Height of buttons on the GUI. **/
    private static final int BUTTON_HEIGHT = 150;

    /******************************************************************
     * Calls for the initilization of icons and prepares the frame for
     * the GUI but does not add the buttons.
     *****************************************************************/
    public WarioWareGUI() {

        //Calls for the initialization of icons
        initIcons();

        //creates and sets parameters for the GUI
        JFrame guiFrame = new JFrame("Wario Ware 2.0");
        guiFrame.setPreferredSize(new Dimension(GUI_WIDTH, GUI_HEIGHT));
        guiFrame.setLocation(FRAME_X_LOCATION, FRAME_Y_LOCATION);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.pack();
        guiFrame.setVisible(true);

        //Instantiates the coin icon
        Icon coin = new ImageIcon("coin.jpg");

        //places the coin icon on the button and sets its parameters
        JButton coinSelect = new JButton(coin);
        coinSelect.setBounds(COIN_BUTTON_X, COIN_BUTTON_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT);

        //places the button on the GUI frame
        guiFrame.add(coinSelect);
        coinSelect.setVisible(true);

        //enables the button to launch the coin collector game
        coinSelect.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {

                //closes the GUI
                guiFrame.dispose();

                //launches the coin collector game and its GUI
                launchCoins();

                }
            });

        //creates button, places mario icon on it, sets its parameters
        JButton memorySelect = new JButton(null, thinkingMario);
        memorySelect.setBounds(MEMORY_BUTTON_X, MEMORY_BUTTON_Y,
                BUTTON_WIDTH, BUTTON_HEIGHT);

        //adds the button to the GUI
        guiFrame.add(memorySelect);
        memorySelect.setVisible(true);

        //enables the button to launch the memory match game
        memorySelect.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {

                //closes the GUI
                guiFrame.dispose();

                //launches the coin collector game and its GUI
                launchMemory();
                }
            });

        //repaints the GUI to ensure it is layered properly
        guiFrame.repaint();

        }

    /******************************************************************
    * Instantiates the WarioWareGUI Object.
    *
    * @param args default string arguments for WarioWareGUI main
    ****************************************************************/

    public static void main(final String[] args) {

        WarioWareGUI gui = new WarioWareGUI();

    }

    /******************************************************************
     * Instantiates the Coin Collector game GUI as a CollectPanel
     * object and sets the parameters of the GUI. This also
     * launches the game
     *****************************************************************/

    public void launchCoins() {

        //Creates the new GUI object for the coin collect game
        CollectPanel collect = new CollectPanel();

        //sets the parameters of the new GUI
        setContentPane(collect);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wario Ware 2.0");
        pack();
        setVisible(true);
        }

    /******************************************************************
     * Instantiates the Memory Match game GUI as a MemoryBoard
     * object and sets the parameters of the GUI. This also
     * launches the game.
     *****************************************************************/

    public void launchMemory() {

        //Creates the new GUI object for the memory match game
        //This also launches the game
        MemoryBoard b = new MemoryBoard();

        //sets parameters of the new GUI
        b.setPreferredSize(new Dimension(GUI_WIDTH, GUI_HEIGHT));
        b.setLocation(FRAME_X_LOCATION, FRAME_Y_LOCATION);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);

        }

    /***********************************************
     * Initializes all image icons.
     **********************************************/
    private void initIcons() {

        thinkingMario = new ImageIcon(new ImageIcon("ThinkingMario.png")
                .getImage().getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        }
    }