package GameProject;

import java.awt.EventQueue;
import javax.swing.JFrame;

/***********************************************
 * A test class for
 **********************************************/
public class SpaceInvaders extends JFrame implements SpaceCommons {


    public SpaceInvaders() {

        initUI();
    }

    private void initUI() {

        add(new SpaceBoard());
        setTitle("Goomba Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SpaceInvaders ex = new SpaceInvaders();
            ex.setVisible(true);
        });
    }
}