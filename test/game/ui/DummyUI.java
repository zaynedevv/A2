package game.ui;

import game.achievements.Achievement;
import game.core.SpaceObject;
import game.GameModel;
import game.ui.KeyHandler;
import game.ui.Tickable;
import game.ui.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a GUI implementation of the UI interface.
 */
public class DummyUI implements UI {

    @Override
    public void start() {

    }

    /**
     * Displays the game welcome message and instructions.
     */
    private void logWelcome() {

    }

    /**
     * Alternates between paused and unpaused state.
     */
    @Override
    public void pause() {

    }

    /**
     * Pauses the game
     */
    @Override
    public void stop() {

    }

    /**
     * Stores the provided tickable.
     * @param tickable the provided tickable
     */
    @Override
    public void onStep(Tickable tickable) {

    }

    /**
     * Stores the provided KeyHandler.
     * @param key the provided KeyHandler
     */
    @Override
    public void onKey(KeyHandler key) {

    }

    /**
     * Renders the provided objects, and refreshes the UI.
     *
     * @param objects the list of SpaceObjects to be rendered.
     */
    @Override
    public void render(List<SpaceObject> objects) {

    }

    /**
     * Log the provided message.
     *
     * @param message the provided message
     */
    @Override
    public void log(String message) {

    }

    /**
     * Sets the stats to the provided label and value.
     *
     * @param label the provided label
     * @param value the provided value
     */
    @Override
    public void setStat(String label, String value) {

    }

    @Override
    public void logAchievementMastered(String message) {
    }

    @Override
    public void logAchievements(List<Achievement> achievements) {


    }
    @Override
    public void setAchievementProgressStat(String achievementName, double progressPercentage) {

    }
}

