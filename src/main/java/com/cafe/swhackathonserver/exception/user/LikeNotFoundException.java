package com.cafe.swhackathonserver.exception.user;

import com.cafe.swhackathonserver.exception.Message;
import com.cafe.swhackathonserver.exception.SwhackathonException;

import org.springframework.http.HttpStatus;

public class LikeNotFoundException extends SwhackathonException {
    public LikeNotFoundException() {
        super(Message.LIKE_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
