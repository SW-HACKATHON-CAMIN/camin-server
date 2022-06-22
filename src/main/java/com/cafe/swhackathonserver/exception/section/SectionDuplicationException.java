package com.cafe.swhackathonserver.exception.section;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class SectionDuplicationException extends SectionException{
    public SectionDuplicationException() {
        super(Message.SECTION_DUPLICATIE, HttpStatus.BAD_REQUEST);
    }
}
