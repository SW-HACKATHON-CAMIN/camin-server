package com.cafe.swhackathonserver.exception.section;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class SectionNotFoundException extends SectionException{
    public SectionNotFoundException() {
        super(Message.SECTION_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
