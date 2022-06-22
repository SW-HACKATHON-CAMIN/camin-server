package com.cafe.swhackathonserver.exception.user;

import com.cafe.swhackathonserver.exception.Message;
import com.cafe.swhackathonserver.exception.SwhackathonException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SwhackathonException {
    public UserNotFoundException() {
        super(Message.USER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
