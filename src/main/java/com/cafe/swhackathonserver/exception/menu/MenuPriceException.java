package com.cafe.swhackathonserver.exception.menu;

import com.cafe.swhackathonserver.exception.Message;

import org.springframework.http.HttpStatus;

public class MenuPriceException extends MenuException{
    public MenuPriceException() {
        super(Message.MENU_PRICE_EXCEPTION, HttpStatus.BAD_REQUEST);
    }
}
