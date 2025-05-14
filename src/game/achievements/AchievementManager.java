package game.achievements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Achievement Manager class is responsible for managing all achievements
 * - Adding achievements
 * - Retreiving achievements
 * - Logging achievements
 * - Updating achievements
 */
public class AchievementManager {

    /// Maps all achievement names to their corresponding values
    private Map<String, Achievement> achievementMap;

    /// The achievement file
    private AchievementFile achievementFile;

    /**
     * Creates a new Achievement Manager Object
     * @param achievementFile the AchievementFile that will be written to
     * @throws IllegalArgumentException if achievementfile is null
     */
    public AchievementManager(AchievementFile achievementFile) {
        if (achievementFile == null) {
            throw new IllegalArgumentException("achievementFile cannot be null");
        }
        this.achievementFile = achievementFile;
        this.achievementMap = new HashMap<>();
    }

    /**
     * Add's an achievement to the list of achievements
     * @param achievement The achievement to add to the list
     * @throws IllegalArgumentException if achievementmap contains the achievement already
     */
    public void addAchievement(Achievement achievement) {
        if (achievement != null) {
            if (achievementMap.containsKey(achievement.getName())) {
                throw new IllegalArgumentException("Achievement already exists");
            }
            achievementMap.put(achievement.getName(), achievement);
        }
    }

    /**
     * Retrieves all the achievements the player currently has obtained
     * @return List of already obtained achievements
     */
    public List<Achievement> getAchievements() {
        return new ArrayList<>(achievementMap.values());
    }

    /**
     * Logs all mastered achievements to the text file
     */
    public void logAchievementMastered() {
        for (Achievement achievement : achievementMap.values()) {
            if (achievement.getProgress() >= 0.999) {
                achievementFile.save("Achievement Mastered: " + achievement.getName());
            }
        }
    }

    /**
     * Updates the progress of an existing achievement
     * @param achievementName The name of the achievement to add
     * @param absoluteProgressValue The progress the user has towards that achievement
     * @throws IllegalArgumentException if it cannot find the achievement to update
     */
    public void updateAchievement(String achievementName, double absoluteProgressValue) {
        if (achievementName != null && !achievementName.trim().isEmpty()) {
            Achievement achievement = achievementMap.get(achievementName);
            if (achievement == null) {
                throw new IllegalArgumentException("Achievement name cannot be null or empty");
            }
            achievement.setProgress(absoluteProgressValue);


        }

    }

}
