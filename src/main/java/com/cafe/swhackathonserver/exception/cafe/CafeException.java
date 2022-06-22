package com.cafe.swhackathonserver.exception.cafe;

import com.cafe.swhackathonserver.exception.SwhackathonException;

import org.springframework.http.HttpStatus;

public class CafeException extends SwhackathonException {
    public CafeException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
