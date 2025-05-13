package game;

import game.achievements.Achievement;
import game.achievements.AchievementManager;
import game.achievements.PlayerStatsTracker;
import game.core.SpaceObject;
import game.exceptions.BoundaryExceededException;
import game.ui.UI;
import game.utility.Direction;

import java.util.List;

/**
 * The Controller handling the game flow and interactions.
 * <p>
 * Holds references to the UI and the Model, so it can pass information and references back and forth as necessary.<br>
 * Manages changes to the game, which are stored in the Model, and displayed by the UI.<br>
 */
public class GameController {
    private final long startTime;
    private final UI ui;
    private final GameModel model;
    private final AchievementManager aManager;
    private boolean isPaused;
    private boolean verbose;


    /**
     * An internal variable indicating whether certain methods should log their actions.
     * Not all methods respect isVerbose.
     */
    private boolean isVerbose = false;


    /**
     * Initializes the game controller with the given UI, GameModel and AchievementManager.<br>
     * Stores the UI, GameModel, AchievementManager and start time.<br>
     * The start time System.currentTimeMillis() should be stored as a long.<br>
     * Starts the UI using UI.start().<br>
     *
     * @param ui the UI used to draw the Game
     * @param model the model used to maintain game information
     * @param aManager the manager used to maintain achievement information
     *
     * @requires ui is not null
     * @requires model is not null
     * @requires achievementManager is not null
     * @provided
     */
    public GameController(UI ui, GameModel model, AchievementManager aManager) {
        if (ui == null || model == null || aManager == null) {
            throw new IllegalArgumentException();
        }
        this.ui = ui;
        this.model = model;
        this.startTime = System.currentTimeMillis();
        this.aManager = aManager;
        ui.start();
    }


    /**
     * Initializes the game controller with the given UI and GameModel.<br>
     * Stores the ui, model and start time.<br>
     * The start time System.currentTimeMillis() should be stored as a long.<br>
     *
     * @param ui    the UI used to draw the Game
     * @param aManager the manager used to maintain achievement information
     *
     * @requires ui is not null
     * @requires achievementManager is not null
     * @provided
     */
    public GameController(UI ui, AchievementManager aManager) {
        if (ui == null || aManager == null) {
            throw new IllegalArgumentException();
        }

        this.ui = ui;
        this.startTime = System.currentTimeMillis();
        this.aManager = aManager;
        this.model = new GameModel(ui::log, new PlayerStatsTracker());
        ui.start();
    }

    /**
     * Starts the main game loop.<br>
     * <p>
     * Passes onTick and handlePlayerInput to ui.onStep and ui.onKey respectively.
     * @provided
     */
    public void startGame() {
        ui.onStep(this::onTick);
        ui.onKey(this::handlePlayerInput);
    }


    /**
     * Handles user keyboard input to move the ship object
     * @param input the user keyboard input that is pressed
     */
    public void handlePlayerInput(String input) {
        Direction dir = null;


        if (input.toLowerCase().equals("w")) {
            dir = Direction.UP;
        } else if (input.toLowerCase().equals("a")) {
            dir = Direction.LEFT;
        } else if (input.toLowerCase().equals("s")) {
            dir = Direction.DOWN;
        } else if (input.toLowerCase().equals("d")) {
            dir = Direction.RIGHT;
        } else if (input.toLowerCase().equals("f")) {
            model.fireBullet();
        } else if (input.toLowerCase().equals("p")) {
            this.pauseGame();
        } else {
            ui.log("Invalid input. Use W, A, S, D, F, or P.");
        }
        try {
            if (dir != null) {
                model.getShip().move(dir);
            }
        } catch (BoundaryExceededException e) {
            System.out.println(e.getMessage());
        }

        ui.log("Core.Ship moved to (" + model.getShip().getX()
                + ", " + model.getShip().getY() + ")");
    }

    /** Pauses all elements in the game */
    public void pauseGame() {
        if (isPaused) {
            ui.log("Game unpaused.");
        } else {
            ui.log("Game paused.");
        }
        isPaused = !isPaused;
        ui.pause();
    }


    /**
     * Uses the provided tick to call and advance the following:<br>
     * - A call to model.updateGame(tick) to advance the game by the given tick.<br>
     * - A call to model.checkCollisions() to handle game interactions.<br>
     * - A call to model.spawnObjects() to handle object creation.<br>
     * - A call to model.levelUp() to check and handle leveling.<br>
     * - A call to refreshAchievements(tick) to handle achievement updating.<br>
     * - A call to renderGame() to draw the current state of the game.<br>
     * @param tick the provided tick
     * @provided
     */
    public void onTick(int tick) {
        model.updateGame(tick); // Update GameObjects
        model.checkCollisions(); // Check for Collisions
        model.spawnObjects(); // Handles new spawns
        model.levelUp(); // Level up when score threshold is met
        refreshAchievements(tick); // Handle achievement updating.
        renderGame(); // Update Visual

        // Check game over
        if (model.checkGameOver()) {
            pauseGame();
            showGameOverWindow();
        }
    }

    /**
     * Renders the stats of the game
     *
     */

    public void renderGame() {
        ui.setStat("Score", String.valueOf(model.getShip().getScore()));
        ui.setStat("Health", String.valueOf(model.getShip().getHealth()));
        ui.setStat("Level", String.valueOf(model.getLevel()));
        ui.setStat("Time Survived", (System.currentTimeMillis() - startTime) / 1000 + " seconds");
        ui.render(model.getSpaceObjects());
    }

    /**
     * Updates achievements with necessary values on each tick
     * @param tick the games tick
     */

    public void refreshAchievements(int tick) {
        // Survivor Achievement: Mastered at 120 seconds
        double survivorProgress = Math.min(this.getStatsTracker().getElapsedSeconds() / 120.0, 1.0);
        this.aManager.updateAchievement("Survivor", survivorProgress);

        // Enemy Exterminator Achievement: Mastered at 20 shots hit
        double exterminatorProgress = Math.min(this.getStatsTracker().getShotsHit() / 20.0, 1.0);
        this.aManager.updateAchievement("Enemy Exterminator", exterminatorProgress);

        // Sharp Shooter Achievement: Requires >10 shots fired
        double accuracyProgress = 0.0;
        if (this.getStatsTracker().getShotsFired() > 10) {
            accuracyProgress = Math.min(this.getStatsTracker().getAccuracy() / 0.99, 1.0);
        }
        this.aManager.updateAchievement("Sharp Shooter", accuracyProgress);

        // Get newly mastered achievements and update UI
        for (Achievement a : this.aManager.getAchievements()) {
            ui.setStat(a.getName(), Double.toString(a.getProgress()));
        }

        // Log progress every 100 ticks if verbose is enabled
        if (this.verbose == true && tick % 100 == 0) {
            ui.log("Achievement Progress:");
            ui.log("  Survivor: " + survivorProgress);
            ui.log("  Enemy Exterminator: " + exterminatorProgress);
            ui.log("  Sharp Shooter: " + accuracyProgress);
        }
    }

    /**
     * Retrieves the player stats tracker object from the game model
     * @return playerStatsTracker object
     */
    public PlayerStatsTracker getStatsTracker() {
        return model.getPlayerStatsTracker();
    }

    /**
     * Sets the verbose state to the value of the verbose parameter
     * @param verbose the verbose state that is being set
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
        model.setVerbose(verbose);
    }


    /**
     * Displays a Game Over window containing the player's final statistics and achievement
     * progress.<br>
     * <p>
     * This window includes:<br>
     * - Number of shots fired and shots hit<br>
     * - Number of Enemies destroyed<br>
     * - Survival time in seconds<br>
     * - Progress for each achievement, including name, description, completion percentage
     * and current tier<br>
     * @provided
     */
    private void showGameOverWindow() {

        // Create a new window to display game over stats.
        javax.swing.JFrame gameOverFrame = new javax.swing.JFrame("Game Over - Player Stats");
        gameOverFrame.setSize(400, 300);
        gameOverFrame.setLocationRelativeTo(null); // center on screen
        gameOverFrame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);


        StringBuilder sb = new StringBuilder();
        sb.append("Shots Fired: ").append(getStatsTracker().getShotsFired()).append("\n");
        sb.append("Shots Hit: ").append(getStatsTracker().getShotsHit()).append("\n");
        sb.append("Enemies Destroyed: ").append(getStatsTracker().getShotsHit()).append("\n");
        sb.append("Survival Time: ").append(getStatsTracker().getElapsedSeconds()).append(" seconds\n");


        List<Achievement> achievements = aManager.getAchievements();
        for (Achievement ach : achievements) {
            double progressPercent = ach.getProgress() * 100;
            sb.append(ach.getName())
                    .append(" - ")
                    .append(ach.getDescription())
                    .append(" (")
                    .append(String.format("%.0f%%", progressPercent))
                    .append(" complete, Tier: ")
                    .append(ach.getCurrentTier())
                    .append(")\n");
        }

        String statsText = sb.toString();

        // Create a text area to show stats.
        javax.swing.JTextArea statsArea = new javax.swing.JTextArea(statsText);
        statsArea.setEditable(false);
        statsArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));

        // Add the text area to a scroll pane (optional) and add it to the frame.
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(statsArea);
        gameOverFrame.add(scrollPane);

        // Make the window visible.
        gameOverFrame.setVisible(true);
    }

}

