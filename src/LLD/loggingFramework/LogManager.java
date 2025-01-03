package LLD.loggingFramework;

import LLD.loggingFramework.LogHandlers.ConsoleLogHandler;

public class LogManager {
    private static LogManager instance;
    private Logger logger;

    private LogManager() {
        // Default configuration (Console logging, INFO level)
        LogHandler consoleHandler = new ConsoleLogHandler();
        this.logger = Logger.getInstance(consoleHandler, LogLevel.INFO);
    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }

    public void configureLogger(LogHandler logHandler, LogLevel logLevel) {
        logger.setLogHandler(logHandler);
        logger.setLogLevel(logLevel);
    }
}
