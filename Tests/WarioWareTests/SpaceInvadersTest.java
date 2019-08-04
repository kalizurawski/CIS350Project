package WarioWareTests;

import GameProject.*;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class SpaceInvadersTest {

    /** space sprite. **/
    SpaceSprite sprite;

    /** player. **/
    SpacePlayer player;

    /** shot. **/
    Shot shot;

    /** alien. **/
    Aliens alien;

    /** space board. **/
    SpaceBoard board;

    // Testing SpaceSprite class
    @Test
    public void testDie() {
        // instantiate
        sprite = new SpaceSprite();

        // set dead
        sprite.die();
        assertFalse(sprite.isVisible());

    }

    @Test
    public void testSetGetVisible() {
        // instantiate
        sprite = new SpaceSprite();

        // set invisible
        sprite.setVisible(false);
        assertFalse(sprite.isVisible());

        // set visible
        sprite.setVisible(true);
        assertTrue(sprite.isVisible());
    }

    @Test
    public void testSetGetX() {
        // instantiate
        sprite = new SpaceSprite();

        // set x
        sprite.setX(4);
        assertEquals(4, sprite.getX());

    }

    @Test
    public void testSetGetY() {
        // instantiate
        sprite = new SpaceSprite();

        // set y
        sprite.setY(4);
        assertEquals(4, sprite.getY());

    }

    @Test
    public void testSetGetDying() {
        // instantiate
        sprite = new SpaceSprite();

        // set dying
        sprite.setDying(true);
        assertTrue(sprite.isDying());

        // set not dying
        sprite.setDying(false);
        assertFalse(sprite.isDying());


    }
    
    // Testing SpacePlayer class
    @Test
    public void testKeyPressRight() {
        // instantiate
        player = new SpacePlayer();

        Button a = new Button("click");
        KeyEvent e;
        for (int i = 0; i < 200; i++) {
            e = new KeyEvent(a, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                    0, KeyEvent.VK_RIGHT, '0');

            player.keyPressed(e);

            e = new KeyEvent(a, KeyEvent.KEY_RELEASED, System.currentTimeMillis(),
                    0, KeyEvent.VK_RIGHT, '0');

            player.keyReleased(e);
        }
    }

    @Test
    public void testKeyPressLeft() {
        // instantiate
        player = new SpacePlayer();

        Button a = new Button("click");
        KeyEvent e;

        // move all the way left
        for(int i = 0; i < 200; i++) {
            e = new KeyEvent(a, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                    0, KeyEvent.VK_LEFT, '0');

            player.keyPressed(e);

            e = new KeyEvent(a, KeyEvent.KEY_RELEASED, System.currentTimeMillis(),
                    0, KeyEvent.VK_LEFT, '0');

            player.keyReleased(e);
        }
    }

    // Testing Shot class
    @Test
    public void testShot() {
        // instantiate
        shot = new Shot(1, 1);

        // test
        assertEquals(7, shot.getX());
        assertEquals(0, shot.getY());
    }

    // Testing SpaceBoard class??
    @Test
    public void testInitBoard() {
        // instantiate
        board = new SpaceBoard();
    }

    // Testing Aliens class
    @Test
    public void testAct() {
        // instantiate alien
        alien = new Aliens(1, 1);

        // move right
        alien.act(1);
        assertEquals(2, alien.getX());

        // move left
        alien.act(-1);
        assertEquals(1, alien.getX());
    }

    @Test
    public void testGetBomb() {
        // instantiate alien
        alien = new Aliens(1, 1);

        // get bomb loc
        assertEquals(1, alien.getBomb().getX());
        assertEquals(1, alien.getBomb().getX());
    }

    @Test
    public void testSetDestroyed() {
        // instantiate alien
        alien = new Aliens(1, 1);

        // set destroyed
        alien.getBomb().setDestroyed(true);
        assertTrue(alien.getBomb().isDestroyed());

        // set not destroyed
        alien.getBomb().setDestroyed(false);
        assertFalse(alien.getBomb().isDestroyed());
    }
}
