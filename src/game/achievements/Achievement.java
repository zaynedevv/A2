package game.achievements;

public interface Achievement {

    String getCurrentTier();

    String getDescription();

    String getName();

    double getProgress();

    void setProgress(double newProgress);

}
