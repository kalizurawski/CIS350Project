package WarioWareTests;

import GameProject.Collect;
import GameProject.Directions;
import GameProject.SpaceType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectTest {

    /** collect game. **/
    Collect game;

    @Test
    // Tests move left
    public void moveLeft() {
        // instantiate
        game = new Collect("Collect!");

        // move player left
        game.moveLeft();
    }

    @Test
    // Tests move right
    public void moveRight() {
        // instantiate
        game = new Collect("Collect!");

        // move player right
        game.moveRight();

    }

    @Test
    // Tests move up
    public void moveUp() {
        // instantiate
        game = new Collect("Collect!");

        // move player up
        game.moveUp();
    }

    @Test
    // Tests move down
    public void moveDown() {
        // instantiate
        game = new Collect("Collect!");

        // move player down
        game.moveDown();
    }

    @Test
    public void checkWin() {
        // instantiate
        game = new Collect("Collect!");

        // Test when player has not won
        assertFalse(game.checkWin());

        // Test when player has won
        game.forceWin();
        assertTrue(game.checkWin());
    }

    @Test
    public void checkGameOver() {
        // instantiate
        game = new Collect("Collect!");

        // Test game not over
        assertFalse(game.checkGameOver());

        // Test player win
        game.forceWin();
        assertTrue(game.checkGameOver());

        // Test player loss
        game = new Collect("Collect!");
        game.setTimeRemaining(0);
        assertTrue(game.checkGameOver());
    }

    @Test
    // Tests setting time remaining
    public void setTimeRemaining() {
        // instantiate
        game = new Collect("Collect!");

        // set time remaining to zero
        assertEquals(0, game.setTimeRemaining(0));
    }

    @Test
    // Tests to check what piece is in the space
    public void pieceAt() {
        // instantiate
        game = new Collect("Collect!");

        // force win so we know board state
        game.forceWin();
        assertEquals(SpaceType.EMPTY, game.pieceAt(0, 0));
    }

    @Test
    // Tests getting player vertical
    public void getPlayerVertical() {
        // instantiate
        game = new Collect("Collect!");

        // check that it is none
        assertEquals(Directions.NONE, game.getPlayerVertical());
    }

    @Test
    // Tests getting player direction
    public void getPlayerDirection() {
        // instantiate
        game = new Collect("Collect!");

        // check that it is left
        assertEquals(Directions.LEFT, game.getPlayerDirection());
    }


}