package com.cafe.swhackathonserver.exception.menu;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class MenuNotFoundException extends MenuException{
    public MenuNotFoundException() {
        super(Message.MENU_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
