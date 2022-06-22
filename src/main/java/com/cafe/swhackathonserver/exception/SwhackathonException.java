package com.cafe.swhackathonserver.exception;

import org.springframework.http.HttpStatus;

public class SwhackathonException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SwhackathonException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {return httpStatus;}
}
