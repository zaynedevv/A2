package game.achievements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AchievementManager {
    Map<String, Achievement> achievementMap;
    public AchievementFile achievementFile;


    public AchievementManager(AchievementFile achievementFile) {
        if (achievementFile == null) {
            throw new IllegalArgumentException("achievementFile cannot be null");
        }
        this.achievementFile = achievementFile;
        this.achievementMap = new HashMap<>();
    }

    public void addAchievement(Achievement achievement) {
        if (achievement == null) {
            throw new IllegalArgumentException("Achievement cannot be null");
        }
        if (achievementMap.containsKey(achievement.getName())) {
            throw new IllegalArgumentException("Achievement already exists");
        }
        achievementMap.put(achievement.getName(), achievement);
    }

    public List<Achievement> getAchievements() {
        return new ArrayList<>(achievementMap.values());
    }

    public void logAchievementMastered() {
        for (Achievement achievement : achievementMap.values()) {
            if (achievement.getProgress() >= 0.999) {
                achievementFile.save("Achievement Mastered: " + achievement.getName());
            }
        }
    }

    public void updateAchievement(String achievementName, double absoluteProgressValue) {
        if (achievementName == null || achievementName.trim().isEmpty()) {
            throw new IllegalArgumentException("Achievement name cannot be null or empty");
        }
        Achievement achievement = achievementMap.get(achievementName);
        if (achievement == null) {
            throw new IllegalArgumentException("Achievement does not exist");
        }
        achievement.setProgress(absoluteProgressValue);
    }

}
