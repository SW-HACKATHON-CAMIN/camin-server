package com.cafe.swhackathonserver.exception.cafe;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class CafeNotFoundException extends CafeException{
    public CafeNotFoundException() {
        super(Message.CAFE_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
