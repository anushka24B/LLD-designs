package LLD.loggingFramework;

import java.util.concurrent.locks.ReentrantLock;

public class Logger {
    private static Logger instance;
    private LogHandler logHandler;
    private LogLevel logLevel;

    private Logger(LogHandler logHandler, LogLevel logLevel) {
        this.logHandler = logHandler;
        this.logLevel = logLevel;
    }

    private static final ReentrantLock lock = new ReentrantLock();
    public static Logger getInstance(LogHandler logHandler, LogLevel logLevel) {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Logger(logHandler, logLevel);
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public void setLogHandler(LogHandler logHandler) {
        this.logHandler = logHandler;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            LogMessage logMessage = new LogMessage(message, level);
            logHandler.handleLog(logMessage);
        }
    }
}
