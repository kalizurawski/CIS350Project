package GameProject;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MemoryGame{
    public static void main(String[] args){
        MemoryBoard b = new MemoryBoard();
        b.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
        b.setLocation(500, 250);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }   
}
