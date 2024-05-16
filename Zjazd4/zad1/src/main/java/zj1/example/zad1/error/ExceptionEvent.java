package zj1.example.zad1.error;

import org.springframework.http.HttpStatus;

public abstract class ExceptionEvent extends RuntimeException {

    public ExceptionEvent(String message){
        super(message);
    }

    public abstract String getErrorCode();

    public abstract HttpStatus getHttpStatus();
}
