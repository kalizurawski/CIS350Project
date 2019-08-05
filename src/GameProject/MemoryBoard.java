/*****************************************************************
Operates the GUI of the memory match game.

@author Robert Gardner
@Coauthor Kali Zurawski
@version 1.0
 *****************************************************************/

package GameProject;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/** Suppresses serial warnings. **/
@SuppressWarnings("serial")

public class MemoryBoard extends JFrame {
	
    /** vector of cards. **/
    private List<MemoryCard> cards;

    /** card currently selected by user. **/
    private MemoryCard selectedCard;

    /** card 1 object. **/
    private MemoryCard c1;

    /** card 2 object. **/
    private MemoryCard c2;

    /** timer object. **/
    private Timer t;

    /** game timer. **/
    private Timer gameTimer;

    /** Boo Image. **/
    private ImageIcon boo;

    /** Bowser Image. **/
    private ImageIcon bowser;

    /** Dry Bones Image. **/
    private ImageIcon dryBones;

    /** Goomba Image. **/
    private ImageIcon goomba;

    /** Koopa Image. **/
    private ImageIcon koopa;

    /** Mushroom  Image. **/
    private ImageIcon mushroom;

    /** Shy Guy Image. **/
    private ImageIcon shyGuy;

    /** Toad Image. **/
    private ImageIcon toad;

    /** Wario Image. **/
    private ImageIcon wario;

    /** Yoshi Image. **/
    private ImageIcon yoshi;

    /** counter for round number. **/
    private static int round = 1;

    /** remaining time for game. **/
    private static int timeRemaining = 120;

    /** initial time for game. **/
    private static int timeInitial = 120;
    
    private static final int SECOND = 1000;

    /** The delay after looking at cards. **/
    private static final int DELAY = 500;

    /** Adjusted size of images. **/
    private static final int IMAGE_SIZE = 100;

    /**the number of matching cards. **/
    private static final int PAIRS = 10;

    /** number of cards wide the grid is. **/
    private static final int GRID_WIDTH = 5;

    /** number of cards tall the grid is. **/
    private static final int GRID_HEIGHT = 4;

    /******************************************************************
     * Calls for initialization of icons, prepares the frame for the
     * GUI, and places the buttons in the frame.
     *****************************************************************/

    public MemoryBoard() {

        //Initializes all icons
        initIcons();
        
        //Initializes timer
        timeRemaining = timeInitial;

        /** creates a vector of Memorycard objects **/
        List<MemoryCard> cardsList = new ArrayList<MemoryCard>();

        /** creates a vector of integers **/
        List<Integer> cardVals = new ArrayList<Integer>();

        //adds the values to the vector of card values for the
        //corresponding number of pairs
        for (int i = 0; i < PAIRS; i++) {
            cardVals.add(i);
            cardVals.add(i);
            }

        //randomizes the values assigned to each card
        Collections.shuffle(cardVals);

        //creates the cards and assigns them each a value from the
        //cardVals vector of values
        for (int val : cardVals) {

            //instantiates the new memoryCard object
            MemoryCard c = new MemoryCard();

            //assigns the memorycard a value
            c.setId(val);

            //allows the card to be clicked by the user
            c.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent ae) {

                    // sets the card selected as the current card
                    selectedCard = c;

                    // handles displaying proper images
                    doTurn();
                    }
                });
            
            cardsList.add(c);
            }
        this.cards = cardsList;

        //instantiates the timer
        t = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(final ActionEvent ae) {

                //checks match conditions
                checkCards();

                }
            });

        //prevents multiple timers from being active simultaneously
        t.setRepeats(false);

        //sets parameters for the GUI and the card grid
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(GRID_HEIGHT, GRID_WIDTH));
        for (MemoryCard c : cards) {
            pane.add(c);
            }
        setTitle("Memory Match");
        
        
        //starts game timer
        ActionListener actListner = new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent event) {
        		timeRemaining -= 1;
        		setTitle("          Time Remaining: "+ timeRemaining + 
        				"          Round: " + round);
        		
        		if (timeRemaining==0) {
        			
        			gameTimer.stop();
        			
                    //displays the dialog box indicating victory
                    JOptionPane.showMessageDialog(pane, "You lose!"
                    		+ "\nYou made it to round" + round + "!");

                    //Returns to Warioware 2.0 Main Menu
                    dispose();
                    WarioWareGUI gui = new WarioWareGUI();
        		}
        		
        	}
        };

        gameTimer = new Timer(SECOND, actListner);
        gameTimer.start();
        
        }
    

    /******************************************************************
     * Handles the visual aspect of selecting each card.
    *****************************************************************/
    public void doTurn() {
    	
		setTitle("          Time Remaining: "+ timeRemaining + 
				"          Round: " + round);

        //when the first card is selected
        if (c1 == null && c2 == null) {

            //set the first card selected as the active card
            c1 = selectedCard;

            //display the icon corresponding to the card ID
            switch (c1.getId()) {

                case 0 : c1.setIcon(shyGuy);
                break;

                case 1 : c1.setIcon(boo);
                break;

                case 2 : c1.setIcon(bowser);
                break;

                case 3 : c1.setIcon(dryBones);
                break;

                case 4 : c1.setIcon(goomba);
                break;

                case 5 : c1.setIcon(koopa);
                break;

                case 6 : c1.setIcon(mushroom);
                break;

                case 7 : c1.setIcon(toad);
                break;

                case 8 : c1.setIcon(wario);
                break;

                case 9 : c1.setIcon(yoshi);
                break;

                default : System.out.println("This should never happen");

                }
            }

        //when the second card is selected
        if (c1 != null && c1 != selectedCard && c2 == null) {

            //set second card as the active card
            c2 = selectedCard;

            //display the icon corresponding to the card ID
            switch (c2.getId()) {

                case 0 : c2.setIcon(shyGuy);
                break;

                case 1 : c2.setIcon(boo);
                break;

                case 2 : c2.setIcon(bowser);
                break;

                case 3 : c2.setIcon(dryBones);
                break;

                case 4 : c2.setIcon(goomba);
                break;

                case 5 : c2.setIcon(koopa);
                break;

                case 6 : c2.setIcon(mushroom);
                break;

                case 7 : c2.setIcon(toad);
                break;

                case 8 : c2.setIcon(wario);
                break;

                case 9 : c2.setIcon(yoshi);
                break;

                default : System.out.println("This should never happen");

                }

            //starts the timer after selecting a card
            t.start();

            }
        }

    /******************************************************************
     * Checks if the two cards selected by the user match.
     *****************************************************************/
    public void checkCards() {
        if (c1.getId() == c2.getId()) { //match condition

            //disables the cards
            c1.setEnabled(false);
            c2.setEnabled(false);

            //flags the cards as having been matched
            c1.setMatched(true);
            c2.setMatched(true);

            //checks if the game has been won
            if (this.isGameWon()) {
            	
                gameTimer.stop();

                //displays the dialog box indicating victory
                JOptionPane.showMessageDialog(this, "You win!");

                round++;
                dispose();
                reRunGame();
                
                //terminate the program upon acknowledgement of victory
                //System.exit(0);
                }

            }

        //if the cards don't match
        else {

            //'hides' icons
            c1.setIcon(null);
            c2.setIcon(null);

            }

        //reset c1 and c2
        c1 = null;
        c2 = null;

        }

    /******************************************************************
     * Checks if all of the cards have been matched.
     *
     * @return true, in the case that the player has won
     *******************************************************************/
    public boolean isGameWon() {
        for (MemoryCard c: this.cards) {
            if (!(c.getMatched())) {
                return false;
                }
            }
        return true;
        }

    /******************************************************************
     * Reruns the game with a decreased timer
     *******************************************************************/
    
    public void reRunGame() {
        
        /** The X coordinate where the gui will be placed. **/
        final int FRAME_X_LOCATION = 500;

        /** The Y coordinate where the gui will be placed. **/
        final int FRAME_Y_LOCATION = 250;

        /** The gui width. **/
        final int GUI_WIDTH = 500;

        /** The gui height. **/
        final int GUI_HEIGHT = 500;
    	
    	//Creates the new GUI object for the memory match game
        //This also launches the game
        MemoryBoard b = new MemoryBoard();
        
        //resets the timer
        timeRemaining = timeInitial;
        gameTimer.start();

        //sets parameters of the new GUI
        b.setPreferredSize(new Dimension(GUI_WIDTH, GUI_HEIGHT));
        b.setLocation(FRAME_X_LOCATION, FRAME_Y_LOCATION);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
        
    }
    
    
    /******************************************************************
     * Initializes all icons.
     *****************************************************************/
    private void initIcons() {

        shyGuy = new ImageIcon(new ImageIcon("ShyGuy.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        boo = new ImageIcon(new ImageIcon("Boo.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        bowser = new ImageIcon(new ImageIcon("Bowser.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        dryBones = new ImageIcon(new ImageIcon("DryBones.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        goomba = new ImageIcon(new ImageIcon("Goomba.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        koopa = new ImageIcon(new ImageIcon("Koopa.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        mushroom = new ImageIcon(new ImageIcon("Mushroom.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        toad = new ImageIcon(new ImageIcon("Toad.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        wario = new ImageIcon(new ImageIcon("WarioIcon.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        yoshi = new ImageIcon(new ImageIcon("Yoshi.png").getImage()
                .getScaledInstance(IMAGE_SIZE, IMAGE_SIZE,
                        Image.SCALE_DEFAULT));

        }
    }