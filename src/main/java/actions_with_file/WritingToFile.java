package actions_with_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {
    File file;

    public WritingToFile(String fileName) {
        this.file = new File(fileName);
    }

    public void writeToFile(Object o) {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(file, true)))) {
            synchronized (file) {
                writer.write(o + "\r\n");
                writer.flush();
            }
        } catch (IOException e) {
        }
    }

}
