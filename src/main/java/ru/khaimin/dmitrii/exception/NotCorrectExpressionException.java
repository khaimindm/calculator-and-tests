package ru.khaimin.dmitrii.exception;

public class NotCorrectExpressionException extends Exception{
    public NotCorrectExpressionException() {
    }

    public NotCorrectExpressionException(String message) {
        super(message);
    }

    public NotCorrectExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectExpressionException(Throwable cause) {
        super(cause);
    }
}
