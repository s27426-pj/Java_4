package com.example.bookshop.shared;

import com.example.bookshop.error.ForbiddenException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.bookshop.error.ExceptionEvent;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler({ExceptionEvent.class})
    public ResponseEntity<String> handleError(ExceptionEvent exception){

        return ResponseEntity
                .status(exception.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getErrorCode());
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<String> handleForbidden(ForbiddenException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getErrorCode());
    }
}
