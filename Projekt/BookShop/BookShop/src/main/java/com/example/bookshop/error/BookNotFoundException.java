package com.example.bookshop.error;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends ExceptionEvent{

    public BookNotFoundException(String message){
        super(message);
    }

    @Override
    public String getErrorCode(){
        return "Taka Książka nie istnieje";
    }
    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.BAD_REQUEST;
    }
}
