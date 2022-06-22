package com.cafe.swhackathonserver.exception.cafe;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class CafeSectionInfoException extends CafeException{
    public CafeSectionInfoException() {
        super(Message.CAFE_INVALID_SECTION_INFO, HttpStatus.BAD_REQUEST);
    }
}
