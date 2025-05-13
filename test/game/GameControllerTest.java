package game;

import game.achievements.AchievementManager;
import game.achievements.FileHandler;
import game.ui.gui.GUI;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class GameControllerTest {
    @Test
    public void pauseTestW() {
        GameController game = new GameController(new GUI(), new AchievementManager(new FileHandler()));
        game.pauseGame();

        try {
            game.handlePlayerInput("w");
            fail("Game was paused cannot move");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }
    }
    @Test
    public void pauseTestA() {
        GameController game = new GameController(new GUI(), new AchievementManager(new FileHandler()));
        game.pauseGame();

        try {
            game.handlePlayerInput("a");
            fail("Game was paused cannot move");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }
    }
    @Test
    public void pauseTestS() {
        GameController game = new GameController(new GUI(), new AchievementManager(new FileHandler()));
        game.pauseGame();

        try {
            game.handlePlayerInput("s");
            fail("Game was paused cannot move");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }
    }
    @Test
    public void pauseTestD() {
        GameController game = new GameController(new GUI(), new AchievementManager(new FileHandler()));
        game.pauseGame();

        try {
            game.handlePlayerInput("d");
            fail("Game was paused cannot move");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }
    }
}
