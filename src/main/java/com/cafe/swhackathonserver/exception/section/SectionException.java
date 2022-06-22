package com.cafe.swhackathonserver.exception.section;

import com.cafe.swhackathonserver.exception.SwhackathonException;

import org.springframework.http.HttpStatus;

public class SectionException extends SwhackathonException {
    public SectionException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
