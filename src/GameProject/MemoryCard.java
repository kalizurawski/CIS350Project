/*****************************************************************
Setters and getters for the MemoryCard Objects parameters 
utilized in the Memory Match game

@author Robert Gardner
@Coauthor Kali Zurawski
@version 1.0
 *****************************************************************/
package GameProject;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MemoryCard extends JButton{
    
	/** the integer ID of the card **/
	private int id;
    
	/** the status, matched or unmatched, of the card **/
	private boolean matched = false;

	/******************************************************************
	 * Assigns an Integer value to the card to serve as its ID
	 * 
	 * @param id, the integer ID of the card
	 *****************************************************************/
    public void setId(int id){
        this.id = id;
    }

	/******************************************************************
	 * Retrieves Integer value to the card to serve as its ID
	 * 
	 * @param id, The integer ID of the card
	 *****************************************************************/
    public int getId(){
        return this.id;
    }

	/******************************************************************
	 * Sets the card has having been matched i.e. the player 
	 * located the card with a matching ID
	 * 
	 * @param matched, the match status of the card
	 *****************************************************************/
    public void setMatched(boolean matched){
        this.matched = matched;
    }

	/******************************************************************
	 * Gets the matched or unmatched status of the card
	 * 
	 * @param matched, the match status of the card
	 *****************************************************************/
    public boolean getMatched(){
        return this.matched;
    }
}