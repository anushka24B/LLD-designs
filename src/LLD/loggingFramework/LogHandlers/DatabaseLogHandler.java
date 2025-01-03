package LLD.loggingFramework.LogHandlers;

import LLD.loggingFramework.LogHandler;
import LLD.loggingFramework.LogMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogHandler implements LogHandler {

    private final String jdbcUrl;
    private final String username;
    private final String password;

    public DatabaseLogHandler(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public synchronized void handleLog(LogMessage logMessage) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO logs (level, message, timestamp) VALUES (?, ?, ?)")) {
            statement.setString(1, logMessage.getLogLevel().toString());
            statement.setString(2, logMessage.getMessage());
            statement.setLong(3, logMessage.getTimestamp());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
