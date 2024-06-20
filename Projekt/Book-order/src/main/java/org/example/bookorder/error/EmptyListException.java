package org.example.bookorder.error;

import org.springframework.http.HttpStatus;

public class EmptyListException extends ExceptionEvent{

    public EmptyListException(String message){
        super(message);
    }

    @Override
    public String getErrorCode(){
        return "Lista książek jest pusta";
    }
    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.BAD_REQUEST;
    }
}
