package game.achievements;

public class PlayerStatsTracker {
    private long startTime;
    private int shotsFired;
    private int shotsHit;

    public PlayerStatsTracker() {
        this.startTime = System.currentTimeMillis();
        this.shotsFired = 0;
        this.shotsHit = 0;
    }

    public PlayerStatsTracker(long startTime) {
        this.startTime = startTime;
        this.shotsFired = 0;
        this.shotsHit = 0;
    }

    public double getAccuracy() {
        return (double) shotsHit/shotsFired * 100;
    }

    public long getElapsedSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public int getShotsFired() {
        return this.shotsFired;
    }

    public int getShotsHit() {
        return this.shotsHit;
    }

   public  void recordShotsFired() {
        this.shotsFired++;
    }

    public void recordShotHit() {
        this.shotsHit++;
    }

}
