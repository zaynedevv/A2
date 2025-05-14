package game.achievements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class responsible for handling everything related to the achievement file
 * - Save
 * - Read
 * - Set File Location
 * - Get File Location
 */
public class FileHandler implements AchievementFile  {
    /// The default file location of the achievement file
    private String fileLocation = DEFAULT_FILE_LOCATION;

    /**
     * Sets the file location of the achievement file
     * @param fileLocation the location to store the file
     * @throws IllegalArgumentException if file location is null or filelocation is an empty string
     */
    @Override
    public void setFileLocation(String fileLocation) {
        if (fileLocation == null || fileLocation.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.fileLocation = fileLocation;
    }

    /**
     * Retrieves the file location of the file
     * @return String file location of the file
     */
    @Override
    public String getFileLocation() {
        return this.fileLocation;
    }

    /**
     * Read all obtained achievements from the file
     * @return the lines read from the file
     */
    @Override
    public List<String> read() {

        List<String> lines = new ArrayList<>(); //Store lines in the file
        File file = new File(fileLocation); //Store file to read from

        if (!file.exists()) {
            return lines;
        }

        //Read from the file and then cleanup after
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Failed to read from file");
        }

        return lines;
    }

    /**
     * Saves a string of achievement data to a file
     * @param data the achievement string to write to the file
     */
    @Override
    public void save(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write to file");
        }
    }

}
