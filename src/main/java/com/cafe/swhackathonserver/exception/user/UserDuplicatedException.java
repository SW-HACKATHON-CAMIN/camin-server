package com.cafe.swhackathonserver.exception.user;

import com.cafe.swhackathonserver.exception.Message;
import com.cafe.swhackathonserver.exception.SwhackathonException;
import org.springframework.http.HttpStatus;

public class UserDuplicatedException extends SwhackathonException {
    public UserDuplicatedException() {
        super(Message.USER_DUPLICATED, HttpStatus.BAD_REQUEST);
    }
}
