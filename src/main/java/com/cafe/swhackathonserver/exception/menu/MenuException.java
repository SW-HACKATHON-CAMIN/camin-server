package com.cafe.swhackathonserver.exception.menu;

import com.cafe.swhackathonserver.exception.SwhackathonException;

import org.springframework.http.HttpStatus;

public class MenuException extends SwhackathonException {
    public MenuException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
