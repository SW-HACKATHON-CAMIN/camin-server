package com.cafe.swhackathonserver.exception.menu;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class MenuNameBlankException extends MenuException{
    public MenuNameBlankException() {
        super(Message.MENU_NAME_BLANK_EXCEPTION, HttpStatus.BAD_REQUEST);
    }
}
