package game.achievements;

public class PlayerStatsTracker {
    private long startTime;
    private int shotsFired;
    private int shotsHit;

    /**
     * Creates a new playerstatstracker object
     * Initializes startTime at the System.currentTimeMills();
     * Initializes shotsFired at 0
     * Initializes shotsHit at 0
     */
    public PlayerStatsTracker() {
        this.startTime = System.currentTimeMillis();
        this.shotsFired = 0;
        this.shotsHit = 0;
    }

    /**
     * Creates a new playerstatstracker object
     * Initializes shotsFired at 0
     * Initializes shotsHit at 0
     * @param startTime the start time to set for the playerstatstracker
     */
    public PlayerStatsTracker(long startTime) {
        this.startTime = startTime;
        this.shotsFired = 0;
        this.shotsHit = 0;
    }

    /**
     * Retreives the accuracy of the player
     * Accuracy is based of the ratio of shotsHit/shotsFired
     * @return A percentage accuracy of shotsHit/shotsFired
     */
    public double getAccuracy() {
        return (double) shotsHit/shotsFired * 100;
    }

    /**
     * Get total elapsed time since the start of the game
     * @return total elapsed time since the start of the game
     */
    public long getElapsedSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    /**
     * Retrieve the total shots fired
     * @return the total shots fired in the game
     */
    public int getShotsFired() {
        return this.shotsFired;
    }

    /**
     * Retrieve the total shots hit
     * @return the total shots hit in the game
     */
    public int getShotsHit() {
        return this.shotsHit;
    }

    /**
     * Increment the shots fired by one
     */
   public void recordShotsFired() {
        this.shotsFired++;
    }

    /**
     * Increment the shots hit by one
     */
    public void recordShotHit() {
        this.shotsHit++;
    }

}
