package game.core;

import game.exceptions.BoundaryExceededException;
import game.utility.Direction;

import game.ui.ObjectGraphic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ControllableTest {
    @Test
    public void testMoveUpThrowsBoundaryExceededException() {
        Ship ship = new Ship(0, 0, 100);
        try {
            ship.move(Direction.UP);
            fail("Expected BoundaryExceededException when moving UP");
        } catch (BoundaryExceededException ex) {
            assertEquals("Cannot move up. Out of bounds!", ex.getMessage());
        }
    }

    @Test
    public void testMoveLeftThrowsBoundaryExceededException() {
        Ship ship = new Ship(0, 0, 100);
        try {
            ship.move(Direction.LEFT);
            fail("Expected BoundaryExceededException when moving LEFT");
        } catch (BoundaryExceededException ex) {
            assertEquals("Cannot move left. Out of bounds!", ex.getMessage());
        }
    }

    @Test
    public void testMoveDownThrowsBoundaryExceededException() {
        Ship ship = new Ship(650, 600, 100);
        try {
            ship.move(Direction.DOWN);
            fail("Expected BoundaryExceededException when moving DOWN");
        } catch (BoundaryExceededException ex) {
            assertEquals("Cannot move down. Out of bounds!", ex.getMessage());
        }
    }

    @Test
    public void testMoveRightThrowsBoundaryExceededException() {
        Ship ship = new Ship(650, 600, 100);
        try {
            ship.move(Direction.RIGHT);
            fail("Expected BoundaryExceededException when moving RIGHT");
        } catch (BoundaryExceededException ex) {
            assertEquals("Cannot move right. Out of bounds!", ex.getMessage());
        }
    }
}
