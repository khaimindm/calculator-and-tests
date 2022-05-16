package ru.khaimin.dmitrii.exception;

public class NotCorrectOperationException extends Exception{
    public NotCorrectOperationException() {
    }

    public NotCorrectOperationException(String message) {
        super(message);
    }

    public NotCorrectOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectOperationException(Throwable cause) {
        super(cause);
    }
}
