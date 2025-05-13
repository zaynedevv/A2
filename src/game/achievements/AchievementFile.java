package game.achievements;

import java.util.List;

public interface AchievementFile {
    static final String DEFAULT_FILE_LOCATION = "achievements.log";

    String getFileLocation();

    List<String> read();

    void save(String data);

    void setFileLocation(String fileLocation);
}
