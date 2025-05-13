package game.achievements;

import java.util.List;

public interface AchievementFile {
    static final String DEFAULT_FILE_LOCATION = "achievements.log";

    /**
     * Retrieve the file location of the achievement file
     * @return The file location
     */
    String getFileLocation();

    /**
     * Read the contents of the achievement file
     * @return the contents
     */
    List<String> read();

    /**
     * Save data about an achievement to the achievement file
     * @param data the achievement data string
     */
    void save(String data);

    /**
     * Sets the file location for the achievement file
     * @param fileLocation the file location
     */
    void setFileLocation(String fileLocation);
}
