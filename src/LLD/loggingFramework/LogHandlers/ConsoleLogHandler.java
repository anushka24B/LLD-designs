package LLD.loggingFramework.LogHandlers;

import LLD.loggingFramework.LogHandler;
import LLD.loggingFramework.LogMessage;

public class ConsoleLogHandler implements LogHandler {
    @Override
    public synchronized void handleLog(LogMessage logMessage) {
        System.out.println(logMessage.toString());
    }
}
