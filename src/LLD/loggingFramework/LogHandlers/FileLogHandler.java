package LLD.loggingFramework.LogHandlers;

import LLD.loggingFramework.LogHandler;
import LLD.loggingFramework.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogHandler implements LogHandler {

    private final String filePath;

    public FileLogHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public synchronized  void handleLog(LogMessage logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(logMessage.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
