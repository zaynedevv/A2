package game;


import game.achievements.AchievementManager;
import game.achievements.FileHandler;
import game.ui.gui.GUI;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

public class GameControllerTest {


    @Test
    public void movementWhenPausedW() {
        AchievementManager achievementManager = new AchievementManager(new FileHandler());
        GameController gameController = new GameController(new GUI(), achievementManager);

        gameController.startGame();

        gameController.pauseGame();

        try {
            gameController.handlePlayerInput("w");
            fail("player should not be able to move space objects during paused game");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }

    @Test
    public void movementWhenPausedA() {
        AchievementManager achievementManager = new AchievementManager(new FileHandler());
        GameController gameController = new GameController(new GUI(), achievementManager);

        gameController.startGame();

        gameController.pauseGame();

        try {
            gameController.handlePlayerInput("a");
            fail("player should not be able to move space objects during paused game");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }

    @Test
    public void movementWhenPausedS() {
        AchievementManager achievementManager = new AchievementManager(new FileHandler());
        GameController gameController = new GameController(new GUI(), achievementManager);

        gameController.startGame();

        gameController.pauseGame();

        try {
            gameController.handlePlayerInput("s");
            fail("player should not be able to move space objects during paused game");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }

    @Test
    public void movementWhenPausedD() {
        AchievementManager achievementManager = new AchievementManager(new FileHandler());
        GameController gameController = new GameController(new GUI(), achievementManager);

        gameController.startGame();

        gameController.pauseGame();

        try {
            gameController.handlePlayerInput("d");
            fail("player should not be able to move space objects during paused game");
        } catch (Exception e) {
            Assert.assertEquals("Game is paused cannot move", e.getMessage());
        }

    }




}
