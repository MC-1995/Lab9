package srp;

import java.io.FileWriter;
import java.io.IOException;

public class FileReportStorage implements ReportStorage {
    private final String fileName;

    public FileReportStorage() {
        this("report.txt");
    }

    public FileReportStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Report saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }
}