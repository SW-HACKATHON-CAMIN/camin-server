package com.cafe.swhackathonserver.exception.user;

import com.cafe.swhackathonserver.exception.Message;
import com.cafe.swhackathonserver.exception.SwhackathonException;
import org.springframework.http.HttpStatus;

public class KakaoTokenNotFoundException extends SwhackathonException {
    public KakaoTokenNotFoundException() {
        super(Message.KAKAO_TOKEN_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
