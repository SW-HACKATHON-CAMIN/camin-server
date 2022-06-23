package com.cafe.swhackathonserver.exception.cafe;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class CafeNoImageException extends CafeException{
    public CafeNoImageException() {
        super(Message.CAFE_NO_IMAGE, HttpStatus.BAD_REQUEST);
    }
}
