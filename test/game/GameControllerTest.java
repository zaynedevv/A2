package game;

import game.ui.DummyUI;

import game.achievements.AchievementManager;
import game.achievements.FileHandler;
import game.achievements.PlayerStatsTracker;
import game.core.Ship;
import org.junit.Assert;
import org.junit.Test;


public class GameControllerTest {


    @Test
    public void pauseTestA() {
        GameModel model = new GameModel(new DummyUI()::log, new PlayerStatsTracker());
        GameController game = new GameController(new DummyUI(), model, new AchievementManager(new FileHandler()));
        game.startGame();

        Ship playerShip = model.getShip();
        game.pauseGame();

        game.handlePlayerInput("a");

        Assert.assertEquals(playerShip.getX(), 5);
        Assert.assertEquals(playerShip.getY(), 10);
    }

    @Test
    public void pauseTestS() {
        GameModel model = new GameModel(new DummyUI()::log, new PlayerStatsTracker());
        GameController game = new GameController(new DummyUI(), model, new AchievementManager(new FileHandler()));
        game.startGame();

        Ship playerShip = model.getShip();
        game.pauseGame();

        game.handlePlayerInput("s");

        Assert.assertEquals(playerShip.getX(), 5);
        Assert.assertEquals(playerShip.getY(), 10);
    }

    @Test
    public void pauseTestD() {
        GameModel model = new GameModel(new DummyUI()::log, new PlayerStatsTracker());
        GameController game = new GameController(new DummyUI(), model, new AchievementManager(new FileHandler()));
        game.startGame();

        Ship playerShip = model.getShip();
        game.pauseGame();

        game.handlePlayerInput("d");

        Assert.assertEquals(playerShip.getX(), 5);
        Assert.assertEquals(playerShip.getY(), 10);
    }

    @Test
    public void pauseTestW() {
        GameModel model = new GameModel(new DummyUI()::log, new PlayerStatsTracker());
        GameController game = new GameController(new DummyUI(), model, new AchievementManager(new FileHandler()));
        game.startGame();

        Ship playerShip = model.getShip();
        game.pauseGame();

        game.handlePlayerInput("w");

        Assert.assertEquals(playerShip.getX(), 5);
        Assert.assertEquals(playerShip.getY(), 10);
    }

}
