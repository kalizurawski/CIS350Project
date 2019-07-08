package GameProject;

import javax.swing.JFrame;

public class WarioWareGUI extends JFrame {

    public WarioWareGUI() {
        // init game
        CollectPanel collect = new CollectPanel();

        // set pane
        setContentPane(collect);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wario Ware 2.0");
        pack();
        setVisible(true);

        // Welcome screen or intro
    }

    public static void main(final String args[]) {

        WarioWareGUI gui = new WarioWareGUI();
    }
}
