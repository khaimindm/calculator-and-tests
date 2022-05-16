package ru.khaimin.dmitrii.exception;

public class NotCorrectCharacterInExpressionException extends Exception{
    public NotCorrectCharacterInExpressionException() {
    }

    public NotCorrectCharacterInExpressionException(String message) {
        super(message);
    }

    public NotCorrectCharacterInExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectCharacterInExpressionException(Throwable cause) {
        super(cause);
    }
}
