package WarioWareTests;

import GameProject.CollectPlayer;
import GameProject.Directions;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectPlayerTest {

    /** collect player. **/
    CollectPlayer player;

    @Test
    // Tests getting current X
    public void getCurrX() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // test
        assertEquals(1, player.getCurrX());
    }

    @Test
    // Tests setting current X
    public void setCurrX() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // set
        player.setCurrX(2);

        // test
        assertEquals(2, player.getCurrX());
    }

    @Test
    // Tests getting current Y
    public void getCurrY() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // test
        assertEquals(1, player.getCurrY());
    }

    @Test
    // Tests setting current Y
    public void setCurrY() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // set
        player.setCurrY(2);

        // test
        assertEquals(2, player.getCurrY());
    }

    @Test
    // Tests player can move right
    public void moveRight() {
        // instantiate
        player = new CollectPlayer(0, 1, 2, 2);

        // move player
        player.moveRight();

        // check to make sure they have moved
        assertEquals(1, player.getCurrX());
    }

    @Test
    // Tests player can't move too far right
    public void moveFarRight() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // move player
        player.moveRight();

        // check to make sure they have not moved
        assertEquals(1, player.getCurrX());
    }

    @Test
    // Tests player can move left
    public void moveLeft() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // move player
        player.moveLeft();

        // check to make sure they have moved
        assertEquals(0, player.getCurrX());
    }

    @Test
    // Tests player can't move too far left
    public void moveFarLeft() {
        // instantiate
        player = new CollectPlayer(0, 1, 2, 2);

        // move player
        player.moveLeft();

        // check to make sure they have not moved
        assertEquals(0, player.getCurrX());
    }

    @Test
    // Tests player can move up
    public void moveUp() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // move player
        player.moveUp();

        // check to make sure they have moved
        assertEquals(0, player.getCurrY());
    }

    @Test
    // Tests player can't move too far up
    public void moveFarUp() {
        // instantiate
        player = new CollectPlayer(1, 0, 2, 2);

        // move player
        player.moveUp();

        // check to make sure they have not moved
        assertEquals(0, player.getCurrY());
    }

    @Test
    // Tests player can move down
    public void moveDown() {
        // instantiate
        player = new CollectPlayer(1, 0, 2, 2);

        // move player
        player.moveDown();

        // check to make sure they have moved
        assertEquals(1, player.getCurrY());
    }

    @Test
    // Tests player can't move too far down
    public void moveFarDown() {
        // instantiate
        player = new CollectPlayer(1, 0, 2, 2);

        // move player
        player.moveUp();

        // check to make sure they have not moved
        assertEquals(0, player.getCurrY());
    }

    @Test
    // Tests character's facing direction (left/right)
    public void getDirection() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // move right
        player.moveRight();
        // test facing right
        Assert.assertEquals(Directions.RIGHT, player.getDirection());

        // move left
        player.moveLeft();
        // test facing left
        assertEquals(Directions.LEFT, player.getDirection());
    }

    @Test
    // Tests character's facing direction (up/down)
    public void getVertical() {
        // instantiate
        player = new CollectPlayer(1, 1, 2, 2);

        // test facing none
        assertEquals(Directions.NONE, player.getVertical());

        // move up
        player.moveUp();
        // test jumpint up
        assertEquals(Directions.UP, player.getVertical());

        // move down
        player.moveDown();
        // test jumping down
        assertEquals(Directions.DOWN, player.getVertical());
    }
}