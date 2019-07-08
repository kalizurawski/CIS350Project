package GameProject;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class WarioWareGUI extends JFrame {

    public WarioWareGUI() {
        CollectPanel collect = new CollectPanel();
        setContentPane(collect);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wario Ware 2.0");
        pack();
        setVisible(true);

        // Welcome screen or intro
    }

    public static void main(String args[]) {

        WarioWareGUI gui = new WarioWareGUI();
    }
}
