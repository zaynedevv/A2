package game.achievements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileHandler implements AchievementFile  {

    private String fileLocation = DEFAULT_FILE_LOCATION;

    public FileHandler() {
        //
    }

    @Override
    public void setFileLocation(String fileLocation) {
        if (fileLocation == null || fileLocation.isEmpty()) {
            throw new IllegalArgumentException("fileLocation cannot be null");
        }
        this.fileLocation = fileLocation;
    }

    @Override
    public String getFileLocation() {
        return this.fileLocation;
    }

    @Override
    public List<String> read() {
        List<String> lines = new ArrayList<>();
        File file = new File(fileLocation);

        if (!file.exists()) {
            return lines; // Return empty list if file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Failed to read from file: " + e.getMessage());
        }

        return lines;
    }

    @Override
    public void save(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
    }

}
