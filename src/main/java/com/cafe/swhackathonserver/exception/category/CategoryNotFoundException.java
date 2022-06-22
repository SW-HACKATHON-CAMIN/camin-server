package com.cafe.swhackathonserver.exception.category;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends CategoryException{
    public CategoryNotFoundException() {
        super(Message.CATEGORY_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
