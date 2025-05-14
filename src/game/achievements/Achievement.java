package game.achievements;


/**
 * Achievement interface
 * - Retrieve current tier
 * - Retrieve description
 * - Get name
 * - Set Progress
 * - Get Progress
 */
public interface Achievement {
    /**
     * Retrieves the current tier of an achievement
     * @return current tier of an achievement
     */
    String getCurrentTier();

    /**
     * Retrieves the description of an achievement
     * @return The description of the achievement
     */
    String getDescription();

    /**
     * Retrieves the name of an achievement
     * @return The name of the achievement
     */
    String getName();

    /**
     * Retrieves the progress of an achievement
     * @return The progress of the achievement
     */
    double getProgress();

    /**
     * Sets the progress of an achievement
     * @param newProgress The progress amount
     */
    void setProgress(double newProgress);

}
