package com.cafe.swhackathonserver.exception.file;

import com.cafe.swhackathonserver.exception.Message;
import com.cafe.swhackathonserver.exception.SwhackathonException;
import org.springframework.http.HttpStatus;

public class FileUploadException extends SwhackathonException {
    public FileUploadException() {
        super(Message.USER_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
