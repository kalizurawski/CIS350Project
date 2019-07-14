/*****************************************************************
Instantiation and setting of parameters for the GUI of the 
memory match game

@author Robert Gardner
@Coauthor Kali Zurawski
@version 1.0
 *****************************************************************/

package GameProject;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MemoryGame{
    public static void main(String[] args){
    	
    	//instantiates the MemoryBoard object
    	// this also launches the game
        MemoryBoard b = new MemoryBoard();
        
        //sets the parameters of the GUI
        b.setPreferredSize(new Dimension(500,500)); 
        b.setLocation(500, 250);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }   
}
