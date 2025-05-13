package game.core;

import org.junit.Assert;
import org.junit.Test;

public class ShieldPowerUpTest {
    @Test
    public void shieldPowerUpTest() {
        Ship ship = new Ship(0, 0, 100);
        ShieldPowerUp powerUp = new ShieldPowerUp(0,0);
        powerUp.applyEffect(ship);

        Assert.assertEquals(50, ship.getScore());
    }
}
