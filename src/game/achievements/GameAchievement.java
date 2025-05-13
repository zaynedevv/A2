package game.achievements;

public class GameAchievement implements Achievement {
    private String name;
    private String description;
    private double progress;

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

    @Override
    public void setProgress(double newProgress) {
        if (newProgress < 0.0 || newProgress > 1.0) {
            throw new IllegalArgumentException("Progress must be between 0.0 and 1.0.");
        }
        this.progress = newProgress;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getProgress() {
        return this.progress;
    }




}
