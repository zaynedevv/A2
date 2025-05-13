package game;

import game.achievements.Achievement;
import game.achievements.AchievementManager;
import game.achievements.FileHandler;
import game.achievements.PlayerStatsTracker;
import game.core.Ship;
import game.core.SpaceObject;
import game.ui.KeyHandler;
import game.ui.Tickable;
import game.ui.UI;
import game.ui.gui.GUI;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class GameControllerTest {

    static class MockUI implements UI {

        // Implement required methods here
        /**
         * Starts the UI.
         */
        public void start() {
            //
        }

        /**
         * Alternates between paused and unpaused state.
         */
        public void pause() {}

        /**
         * Pauses the game
         */
        public void stop() {}

        /**
         * Stores the provided tickable.
         * @param tickable the provided tickable
         */
        public void onStep(Tickable tickable) {}

        /**
         * Stores the provided KeyHandler.
         * @param key the provided KeyHandler
         */
        public void onKey(KeyHandler key) {}

        /**
         * Renders the provided objects, and refreshes the UI.
         *
         * @param objects the list of SpaceObjects to be rendered.
         */
        public void render(List<SpaceObject> objects) {}

        /**
         * Log the provided message.
         *
         * @param message the provided message
         */
        public void log(String message) {}

        /**
         * Sets the stats to the provided label and value.
         *
         * @param label the provided label
         * @param value the provided value
         */
        public void setStat(String label, String value){}

        /**
         * Logs a message to the UI when an achievement is mastered.<br>
         *
         * @param message the message to be logged
         */
        public void logAchievementMastered(String message) {}

        /**
         * Logs the current progress of all achievements to the UI.<br>
         *
         * @param achievements  the achievements to be logged
         */
        public void logAchievements(List<Achievement> achievements) {}

        /**
         * Updates the name and progress percentage for each achievement.<br>
         *
         * @param achievementName  the name of the achievement
         * @param progressPercentage the progress as a decimal value
         */
        public void setAchievementProgressStat(String achievementName, double progressPercentage) {}


    }
    @Test
    public void WMovementTest() {
        MockUI ui = new MockUI();
        GameModel model = new GameModel(ui::log, new PlayerStatsTracker());
        GameController game = new GameController(ui, model, new AchievementManager(new FileHandler()));
        Ship ship = model.getShip();

        int startingX = ship.getX();
        int startingY = ship.getY();

        game.pauseGame();

        game.handlePlayerInput("w");

        Assert.assertEquals(startingX, ship.getX());
        Assert.assertEquals(startingY, ship.getY());

    }
    @Test
    public void AMovementTest() {
        MockUI ui = new MockUI();
        GameModel model = new GameModel(ui::log, new PlayerStatsTracker());
        GameController game = new GameController(ui, model, new AchievementManager(new FileHandler()));
        Ship ship = model.getShip();

        int startingX = ship.getX();
        int startingY = ship.getY();

        game.pauseGame();

        game.handlePlayerInput("a");

        Assert.assertEquals(startingX, ship.getX());
        Assert.assertEquals(startingY, ship.getY());

    }
    @Test
    public void SMovementTest() {
        MockUI ui = new MockUI();
        GameModel model = new GameModel(ui::log, new PlayerStatsTracker());
        GameController game = new GameController(ui, model, new AchievementManager(new FileHandler()));
        Ship ship = model.getShip();

        int startingX = ship.getX();
        int startingY = ship.getY();

        game.pauseGame();

        game.handlePlayerInput("s");

        Assert.assertEquals(startingX, ship.getX());
        Assert.assertEquals(startingY, ship.getY());

    }
    @Test
    public void DMovementTest() {
        MockUI ui = new MockUI();
        GameModel model = new GameModel(ui::log, new PlayerStatsTracker());
        GameController game = new GameController(ui, model, new AchievementManager(new FileHandler()));
        Ship ship = model.getShip();

        int startingX = ship.getX();
        int startingY = ship.getY();

        game.pauseGame();

        game.handlePlayerInput("d");

        Assert.assertEquals(startingX, ship.getX());
        Assert.assertEquals(startingY, ship.getY());

    }
}
