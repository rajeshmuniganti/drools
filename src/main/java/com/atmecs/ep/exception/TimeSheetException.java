package com.atmecs.ep.exception;

public class TimeSheetException extends Exception {

    private static final long serialVersionUID = 1L;

    public TimeSheetException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeSheetException(String message) {
        super(message);
    }
}
