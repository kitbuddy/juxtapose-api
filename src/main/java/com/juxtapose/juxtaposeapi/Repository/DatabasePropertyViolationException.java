package com.juxtapose.juxtaposeapi.Repository;

import org.springframework.http.HttpStatus;

public class DatabasePropertyViolationException extends Throwable {

    private HttpStatus errorCode;
    private String errorMessage;

    public DatabasePropertyViolationException(String errorMessage, Exception exception, HttpStatus errorCode) {
        super(exception);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
