package com.example.bookshop.error;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ExceptionEvent {

    public ForbiddenException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "Dostęp zabroniony";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
