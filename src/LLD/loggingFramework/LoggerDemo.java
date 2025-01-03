package LLD.loggingFramework;

import LLD.loggingFramework.LogHandlers.ConsoleLogHandler;
import LLD.loggingFramework.LogHandlers.FileLogHandler;

public class LoggerDemo {
    public static void run() {
        LogManager logManager = LogManager.getInstance();

        logManager.configureLogger(new ConsoleLogHandler(), LogLevel.INFO);

        Logger logger = logManager.getLogger();
        logger.log(LogLevel.DEBUG, "This is a debug message."); // Will not be logged (INFO is the minimum level)
        logger.log(LogLevel.INFO, "This is an info message.");
        logger.log(LogLevel.ERROR, "This is an error message.");

        // Change the log handler to FileLogging
        logManager.configureLogger(new FileLogHandler("logs.txt"), LogLevel.ERROR);
        logger.log(LogLevel.FATAL, "This message will go to the file.");
    }
}
