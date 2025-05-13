package game.core;

import game.GameModel;

/**
 * Represents a movable and interactive object in the space game.
 */
public abstract class ObjectWithPosition implements SpaceObject {
    /**
     * The x coordinate of the Object
     */
    protected int x;
    /**
     * The y coordinate of the Object
     */
    protected int y;

    /**
     * Creates a movable and interactive object at the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public ObjectWithPosition(int x, int y) {
        if (x > GameModel.GAME_WIDTH || x < 0) {
            throw new IllegalArgumentException();
        }
        if (y > GameModel.GAME_HEIGHT || y < 0) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + x + ", " + y + ")";
    }
}
