package com.cafe.swhackathonserver.exception.order;

import com.cafe.swhackathonserver.exception.Message;
import com.cafe.swhackathonserver.exception.SwhackathonException;
import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends SwhackathonException {
    public OrderNotFoundException() {
        super(Message.ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
