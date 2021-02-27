package actions_with_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {

    public synchronized void writeToFile(String file, Object o) {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(file, true)))) {
            writer.write(o + "\r\n");
            writer.flush();
        } catch (IOException e) {
        }
    }

}
