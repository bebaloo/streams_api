package com.foxminded.exception;

public class IncorrectFilePathException extends RuntimeException{
    public IncorrectFilePathException(String message, Throwable error) {
        super(message, error);
    }
}
