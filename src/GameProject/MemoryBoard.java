/*****************************************************************
Operates the GUI of the memory match game

@author Robert Gardner
@Coauthor Kali Zurawski
@version 1.0
 *****************************************************************/

package GameProject;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
public class MemoryBoard extends JFrame{

	/** vector of cards **/
	private List<MemoryCard> cards;
	
	/** card currently selected by user **/
	private MemoryCard selectedCard;
	
	/** card 1 object **/
	private MemoryCard c1;
	
	/** card 2 object **/
	private MemoryCard c2;
	
	/** timer object **/
	private Timer t;

	/** Boo Image **/
	private ImageIcon Boo;
	
	/** Bowser Image **/
	private ImageIcon Bowser;
	
	/** Dry Bones Image **/
	private ImageIcon DryBones;
	
	/** Goomba Image **/
	private ImageIcon Goomba;
	
	/** Koopa Image **/
	private ImageIcon Koopa;
	
	/** Mushroom  Image **/
	private ImageIcon Mushroom;
	
	/** Shy Guy Image **/
	private ImageIcon ShyGuy;
	
	/** Toad Image **/
	private ImageIcon Toad;
	
	/** Wario Image **/
	private ImageIcon Wario;
	
	/** Yoshi Image **/
	private ImageIcon Yoshi;

	
	/******************************************************************
	 * Calls for initialization of icons, prepares the frame for the 
	 * GUI, and places the buttons in the frame. 
	 *****************************************************************/
	
	public MemoryBoard(){

		//Initializes all icons
		initIcons();

		//sets the number of matching cards
		int pairs = 10;
		
		//creates a vector of Memorycard objects
		List<MemoryCard> cardsList = new ArrayList<MemoryCard>();
		
		//creates a vector of integers 
		List<Integer> cardVals = new ArrayList<Integer>();

		//adds the values to the vector of card values for the 
		//corresponding number of pairs
		for (int i = 0; i < pairs; i++){
			cardVals.add(i);
			cardVals.add(i);
		}
		
		//randomizes the values assigned to each card
		Collections.shuffle(cardVals);

		//creates the cards and assigns them each a value from the
		//cardVals vector of values
		for (int val : cardVals){
			
			//instantiates the new memoryCard object
			MemoryCard c = new MemoryCard();
			
			//assigns the memorycard a value
			c.setId(val);
			
			//allows the card to be clicked by the user
			c.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
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
		t = new Timer(500, new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				
				//checks match conditions 
				checkCards();
			
			}
		});

		//prevents multiple timers from being active simultaneously
		t.setRepeats(false);

		//sets parameters for the GUI and the card grid
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 5));
		for (MemoryCard c : cards){
			pane.add(c);
		}
		setTitle("Memory Match");
	}

	/******************************************************************
	 * Handles the visual aspect of selecting each card
	 *****************************************************************/
	public void doTurn(){
		
		//when the first card is selected
		if (c1 == null && c2 == null){
			
			//set the first card selected as the active card
			c1 = selectedCard;
			
			//display the icon corresponding to the card ID
			switch(c1.getId())
			{

			case 0 : c1.setIcon(ShyGuy);
			break;

			case 1 : c1.setIcon(Boo);
			break;

			case 2 : c1.setIcon(Bowser);
			break;

			case 3 : c1.setIcon(DryBones);
			break;

			case 4 : c1.setIcon(Goomba);
			break;

			case 5 : c1.setIcon(Koopa);
			break;

			case 6 : c1.setIcon(Mushroom);
			break;

			case 7 : c1.setIcon(Toad);
			break;

			case 8 : c1.setIcon(Wario);
			break;

			case 9 : c1.setIcon(Yoshi);
			break;

			default : System.out.println("This should never happen");

			}
		}

		//when the second card is selected
		if (c1 != null && c1 != selectedCard && c2 == null){
			
			//set second card as the active card
			c2 = selectedCard;

			//display the icon corresponding to the card ID
			switch(c2.getId())
			{

			case 0 : c2.setIcon(ShyGuy);
			break;

			case 1 : c2.setIcon(Boo);
			break;

			case 2 : c2.setIcon(Bowser);
			break;

			case 3 : c2.setIcon(DryBones);
			break;

			case 4 : c2.setIcon(Goomba);
			break;

			case 5 : c2.setIcon(Koopa);
			break;

			case 6 : c2.setIcon(Mushroom);
			break;

			case 7 : c2.setIcon(Toad);
			break;

			case 8 : c2.setIcon(Wario);
			break;

			case 9 : c2.setIcon(Yoshi);
			break;

			default : System.out.println("This should never happen");

			}

			//starts the timer after selecting the card
			t.start();

		}
	}

	/******************************************************************
	 * Checks if the two cards selected by the user match
	 *****************************************************************/
	public void checkCards(){
		if (c1.getId() == c2.getId()){//match condition
			
			//disables the cards
			c1.setEnabled(false); 
			c2.setEnabled(false);
			
			//flags the cards as having been matched
			c1.setMatched(true); 
			c2.setMatched(true);
			
			//checks if the game has been won
			if (this.isGameWon()){
				
				//displays the dialog box indicating victory
				JOptionPane.showMessageDialog(this, "You win!");
				
				//terminate the program upon acknowledgement of victory
				System.exit(0);
			}
		}

		//if the cards don't match
		else{
			
			//'hides' icons
			c1.setIcon(null); 
			c2.setIcon(null);
			
		}
		
		//reset c1 and c2
		c1 = null; 
		c2 = null;

	}

	/******************************************************************
	 * Checks if all of the cards have been matched
	 *****************************************************************/	
	public boolean isGameWon(){
		for(MemoryCard c: this.cards){
			if (c.getMatched() == false){
				return false;
			}
		}
		return true;
	}

	/******************************************************************
	 * Initializes all icons
	 *****************************************************************/
	private void initIcons() {

		ShyGuy = new ImageIcon(new ImageIcon("ShyGuy.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Boo = new ImageIcon(new ImageIcon("Boo.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Bowser = new ImageIcon(new ImageIcon("Bowser.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		DryBones = new ImageIcon(new ImageIcon("DryBones.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Goomba = new ImageIcon(new ImageIcon("Goomba.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Koopa = new ImageIcon(new ImageIcon("Koopa.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Mushroom = new ImageIcon(new ImageIcon("Mushroom.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Toad = new ImageIcon(new ImageIcon("Toad.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Wario = new ImageIcon(new ImageIcon("WarioIcon.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

		Yoshi = new ImageIcon(new ImageIcon("Yoshi.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

	}

}