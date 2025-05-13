package game.core;

import org.junit.Assert;
import org.junit.Test;

public class ObjectWithPositionTest {
    @Test
    public void toStringTestBullet() {
        ObjectWithPosition object = new Bullet(0, 0);

        String objectString = object.toString();

        Assert.assertEquals("Bullet(0, 0)", objectString);
    }

    @Test
    public void toStringTestAsteroid() {
        ObjectWithPosition object = new Asteroid(0, 0);

        String objectString = object.toString();

        Assert.assertEquals("Asteroid(0, 0)", objectString);
    }

    @Test
    public void toStringTestShip() {
        ObjectWithPosition object = new Ship(0, 0, 100);

        String objectString = object.toString();

        Assert.assertEquals("Ship(0, 0)", objectString);
    }

    @Test
    public void toStringTestEnemy() {
        ObjectWithPosition object = new Enemy(0, 0);

        String objectString = object.toString();

        Assert.assertEquals("Enemy(0, 0)", objectString);
    }

    @Test
    public void toStringTestHealthPowerUp() {
        ObjectWithPosition object = new HealthPowerUp(0, 0);

        String objectString = object.toString();

        Assert.assertEquals("HealthPowerUp(0, 0)", objectString);
    }

    @Test
    public void toStringTestShieldPowerUp() {
        ObjectWithPosition object = new ShieldPowerUp(0, 0);

        String objectString = object.toString();

        Assert.assertEquals("ShieldPowerUp(0, 0)", objectString);
    }
}
