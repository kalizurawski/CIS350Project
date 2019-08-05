package GameProject;

import java.awt.EventQueue;
import javax.swing.JFrame;

/***********************************************
 * Space Invaders gui.
 **********************************************/
public class SpaceInvaders extends JFrame implements SpaceCommons {


    /***********************************************
     * Initializer.
     **********************************************/
    public SpaceInvaders() {

        initUI();
    }

    /***********************************************
     * UI Initializer.
     **********************************************/
    private void initUI() {

        add(new SpaceBoard());
        setTitle("Space Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /***********************************************
     * Main executable.
     * @param args string arguments
     **********************************************/
    public static void main(final String[] args) {

        EventQueue.invokeLater(() -> {
            SpaceInvaders ex = new SpaceInvaders();
            ex.setVisible(true);
        });
    }
}