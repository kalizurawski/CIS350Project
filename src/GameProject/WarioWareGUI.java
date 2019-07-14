/*****************************************************************
Operates the GUI of the main menu for Warioware 2.0, enabling 
the user to select between two games: a coin collector game and
a memory match game

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

public class WarioWareGUI extends JFrame {

	/** Image Icon for one of the buttons **/
	private ImageIcon ThinkingMario;

	/******************************************************************
	 * Calls for initialization of icons, prepares the frame for the 
	 * GUI, and places the buttons in the frame. It also places the 
	 * images on the buttons
	 *****************************************************************/
	
	public WarioWareGUI() {

		//Calls for the initialization of icons
		initIcons();

		//creates and sets parameters for the GUI
		JFrame guiFrame = new JFrame("Wario Ware 2.0");
		guiFrame.setPreferredSize(new Dimension(500,500));
		guiFrame.setLocation(500, 250);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.pack();
		guiFrame.setVisible(true);

		//Instantiates the coin icon 
		Icon coin = new ImageIcon("coin.jpg");
		
		//places the coin icon on the button and sets its parameters
		JButton coinSelect = new JButton(coin);
		coinSelect.setBounds(275,50,150,150);
		
		//places the button on the GUI frame
		guiFrame.add(coinSelect);
		coinSelect.setVisible(true);
		
		//enables the button to launch the coin collector game
		coinSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				//closes the GUI
				guiFrame.dispose();
				
				//launches the coin collector game and its GUI
				launchCoins();
				
			}
		});

		//creates button, places mario icon on it, sets its parameters
		JButton memorySelect = new JButton(null, ThinkingMario);
		memorySelect.setBounds(50,50,150,150);
		
		//adds the button to the GUI
		guiFrame.add(memorySelect);
		memorySelect.setVisible(true);
		
		//enables the button to launch the memory match game
		memorySelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
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
	 * Instantiates the WarioWareGUI Object
	 *****************************************************************/
	
	public static void main(final String args[]) {

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
	 * launches the game
	 *****************************************************************/
	
	public void launchMemory() {

		//Creates the new GUI object for the memory match game
		//This also launches the game
		MemoryBoard b = new MemoryBoard();
		
		//sets parameters of the new GUI
		b.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
		b.setLocation(500, 250);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.pack();
		b.setVisible(true);

	}

	/***********************************************
	 * Initializes all image icons.
	 **********************************************/
	private void initIcons() {

		ThinkingMario = new ImageIcon(new ImageIcon("ThinkingMario.png").getImage()
				.getScaledInstance(100, 100,
						Image.SCALE_DEFAULT));

	}


}