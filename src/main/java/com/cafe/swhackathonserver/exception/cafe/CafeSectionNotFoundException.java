package com.cafe.swhackathonserver.exception.cafe;

import com.cafe.swhackathonserver.exception.Message;
import org.springframework.http.HttpStatus;

public class CafeSectionNotFoundException extends CafeException {
    public CafeSectionNotFoundException() {
        super(Message.CAFE_SECTION_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
