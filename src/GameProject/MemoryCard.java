/*****************************************************************
* Functions for Memory Match game.
*
* @author Robert Gardner
* @Coauthor Kali Zurawski
* @version 1.0
 ******************************************************************/
package GameProject;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MemoryCard extends JButton {
    /** the integer ID of the card. **/
    private int id;

    /** the status, matched or unmatched, of the card. **/
    private boolean matched = false;

    /******************************************************************
     * Assigns an Integer value to the card to serve as its ID.
     *
     * @param cardId the integer ID of the card
     *****************************************************************/
    public void setId(final int cardId) {
        this.id = cardId;
    }

    /******************************************************************
     * Retrieves Integer value to the card to serve as its ID.
     *
     * @return id, The integer ID of the card
     *****************************************************************/
    public int getId() {
        return this.id;
    }

    /******************************************************************
     * Sets the card has having been matched or not.
     *
     * @param cardMatch the match status of the card
     * *****************************************************************/
    public void setMatched(final boolean cardMatch) {
        this.matched = cardMatch;
    }

    /******************************************************************
     * Gets the matched or unmatched status of the card.
     *
     * @return matched, the match status of the card
     *****************************************************************/
    public boolean getMatched() {
        return this.matched;
    }
}