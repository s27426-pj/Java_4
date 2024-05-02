package zj1.example.zad1.shared;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zj1.example.zad1.error.ExceptionEvent;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler({ExceptionEvent.class})
    public ResponseEntity<String> handleError(ExceptionEvent exception){

        return ResponseEntity
                .status(exception.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getErrorCode());
    }
}
