package LLD.loggingFramework;

public class LogMessage {
    private final String message;
    private final LogLevel logLevel;
    private final long timestamp;

    public LogMessage(String message, LogLevel logLevel) {
        this.message = message;
        this.logLevel = logLevel;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + logLevel + ": " + message;
    }

    public String getMessage() {
        return this.message;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
