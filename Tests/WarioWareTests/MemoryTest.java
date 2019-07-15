package WarioWareTests;

import GameProject.MemoryBoard;
import org.junit.Test;
import javax.swing.JFrame;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MemoryTest {
	
	@Test
	public void gameTest() throws AWTException, InterruptedException{
		
        MemoryBoard b = new MemoryBoard();
        
        b.setPreferredSize(new Dimension(500,500)); 
        b.setLocation(50, 50);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
		b.setVisible(true);
		Thread.sleep(5000);
		
		Robot bot = new Robot();
		
		for (int l=0;l<4;l++) {
			for (int k=0;k<5;k++) {
				for (int i=0;i<4;i++) {
					for (int j=0;j<5;j++){
						
						if (b.isGameWon())
							break;

						Thread.sleep(2);
						bot.mouseMove(100+(k*100),100+(l*125));
						Thread.sleep(2);
						bot.mousePress(InputEvent.BUTTON1_MASK);
						Thread.sleep(2);
						bot.mouseRelease(InputEvent.BUTTON1_MASK);

						Thread.sleep(2);
						bot.mouseMove(100+(j*100),100+(i*125));
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