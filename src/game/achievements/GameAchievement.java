package game.achievements;

/**
 * Game achievement class
 * - Get current tier
 * - Set progress
 * - Get name
 * - Get description
 * - Get progress
 */
public class GameAchievement implements Achievement {
    private String name;
    private String description;
    private double progress;

    /**
     *
     * @param name The name of the achievement
     * @param description The description of the achievement
     * @throws IllegalArgumentException if the name or description is null or empty
     */
    public GameAchievement(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Achievement name cannot be null or empty.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Achievement description cannot be null or empty.");
        }
        this.name = name;
        this.description = description;
        this.progress = 0;
    }

    /**
     * Retrieves the current tier of the achievement
     * - "Novice" if progress < 0.5
     * - "Expert" if 0.5 ≤ progress < 0.999
     * - "Master" if progress ≥ 0.999
     * @return A string representing the current tier
     */
    @Override
    public String getCurrentTier() {
        if (this.getProgress() < 0.5) {
            return "Novice";
        } else if (this.getProgress() >= 0.5 && this.getProgress() < 0.999) {
            return "Expert";
        } else {
            return "Master";
        }
    }

    /**
     * Sets a new progress value for the achievement
     * @param newProgress the new progress value to set for the achievement
     */
    @Override
    public void setProgress(double newProgress) {
        if (newProgress < 0.0 || newProgress > 1.0) {
            throw new IllegalArgumentException("Progress must be between 0.0 and 1.0.");
        }
        this.progress = newProgress;
    }

    /**
     * Retrieves the achievements name
     * @return The achievements name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the description of the achievement
     * @return The achievement description
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the progress of the achievement
     * @return The progress of the achievement
     */
    @Override
    public double getProgress() {
        return this.progress;
    }




}
