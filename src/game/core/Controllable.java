package game.core;

import game.GameModel;
import game.exceptions.BoundaryExceededException;
import game.utility.Direction;
import static game.GameModel.*;

/**
 * Represents a controllable object in the space game.
 */
public abstract class Controllable extends ObjectWithPosition {

    /**
     * Creates a controllable object at the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public Controllable(int x, int y) {
        super(x, y);
    }

    /**
     * Moves the Controllable by one in the direction given.<br>
     * Throws BoundaryExceededException if the Controllable is attempting to move outside the game boundaries.<br>
     * A controllable is considered outside the game boundaries if they are at: <br>
     * x-coordinate &gt;= GAME_WIDTH<br>
     * x-coordinate &lt; 0<br>
     * y-coordinate &gt;= GAME_HEIGHT<br>
     * y-coordinate &lt; 0<br>
     * <p>
     * Argument given to the exception is "Cannot move {up/down/left/right}. Out of bounds!" depending on the direction.
     *
     * @param direction the given direction.
     *
     * @throws BoundaryExceededException if attempting to move outside the game boundaries.
     * @hint game dimensions are stored in the model.
     */
    public void move(Direction direction) throws BoundaryExceededException {

        int newX = this.x;
        int newY = this.y;

        switch (direction) {
            case UP -> newY--;
            case DOWN -> newY++;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        Ship tempShip = new Ship(newX, newY, 100); // Or a generic SpaceObject
        if (!GameModel.isInBounds(tempShip)) {
            throw new BoundaryExceededException("Cannot move. Out of bounds!");
        }

        this.x = newX;
        this.y = newY;
    }

    }
