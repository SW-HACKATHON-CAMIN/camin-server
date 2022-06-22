package com.cafe.swhackathonserver.exception.category;

import com.cafe.swhackathonserver.exception.SwhackathonException;

import org.springframework.http.HttpStatus;

public class CategoryException extends SwhackathonException {
    public CategoryException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
