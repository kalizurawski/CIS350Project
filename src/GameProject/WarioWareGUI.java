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
	
		private ImageIcon ThinkingMario;
	
    public WarioWareGUI() {
    	
    	initIcons();

    	JFrame guiFrame = new JFrame("Wario Ware 2.0");
    	guiFrame.setPreferredSize(new Dimension(500,500));
    	guiFrame.setLocation(500, 250);
    	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	guiFrame.pack();
    	guiFrame.setVisible(true);

    	Icon coin = new ImageIcon("coin.jpg");
    	JButton coinSelect = new JButton(coin);
    	coinSelect.setBounds(275,50,150,150);
    	
    	guiFrame.add(coinSelect);
    	coinSelect.setVisible(true);
    	coinSelect.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
    			guiFrame.dispose();
    			launchCoins();
    		}
    	});
    	
    	JButton memorySelect = new JButton(null, ThinkingMario);
       	memorySelect.setBounds(50,50,150,150);
    	guiFrame.add(memorySelect);
    	memorySelect.setVisible(true);
    	memorySelect.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e){
    			guiFrame.dispose();
    			launchMemory();
    		}
    	});
    	guiFrame.repaint();
    }

    public static void main(final String args[]) {

        WarioWareGUI gui = new WarioWareGUI();

    }
    
    public void launchCoins() {
    	
      CollectPanel collect = new CollectPanel();
    	
      setContentPane(collect);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Wario Ware 2.0");
      pack();
      setVisible(true);
    }
    
    public void launchMemory() {
        
    	MemoryBoard b = new MemoryBoard();
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