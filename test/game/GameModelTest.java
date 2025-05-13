package game.core;

import game.GameModel;
import game.achievements.PlayerStatsTracker;
import game.ui.gui.GUI;
import org.junit.Assert;
import org.junit.Test;

public class GameModelTest {
    @Test
    public void levelTest() {
        GameModel model = new GameModel(new GUI()::log, new PlayerStatsTracker());
        Ship ship = model.getShip();
        int startingLevel = model.getLevel();

        ship.addScore((model.getLevel() * 100) + 1);

        model.levelUp();

        Assert.assertEquals(model.getLevel(), startingLevel + 1);






    }
}
