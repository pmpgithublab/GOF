package ua.tutorial.gof.behavioral;

import lombok.Setter;

// https://refactoring.guru/design-patterns/chain-of-responsibility
public class ChainOfResponsibilityPattern_v1 {
    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(LogLevel.ERROR);
        Logger logger1 = new MailLogger(LogLevel.DEBUG);
        Logger logger2 = new FileLogger(LogLevel.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("Error message.", LogLevel.ERROR);
        logger0.writeMessage("Debug message.", LogLevel.DEBUG);
        logger0.writeMessage("Info message.", LogLevel.INFO);
    }
}

enum LogLevel {
    ERROR,
    DEBUG,
    INFO
}

@Setter
abstract class Logger {
    protected LogLevel priority;
    protected Logger next;
    protected String typeMessage;

    public Logger(LogLevel priority) {
        this.priority = priority;
    }

    public void writeMessage(String message, LogLevel logLevel) {
        if (logLevel.ordinal() <= priority.ordinal()) {
            System.out.println(typeMessage + message);
        }
        if (next != null) {
            next.writeMessage(message, logLevel);
        }
    }
}

class SMSLogger extends Logger {
    public SMSLogger(LogLevel priority) {
        super(priority);
        typeMessage = "SMS: ";
    }
}

class MailLogger extends Logger {
    public MailLogger(LogLevel priority) {
        super(priority);
        typeMessage = "Mail: ";
    }
}

class FileLogger extends Logger {
    public FileLogger(LogLevel priority) {
        super(priority);
        typeMessage = "File: ";
    }
}