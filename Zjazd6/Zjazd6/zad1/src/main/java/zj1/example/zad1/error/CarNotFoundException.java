package zj1.example.zad1.error;

import org.springframework.http.HttpStatus;

public class CarNotFoundException extends ExceptionEvent{

    public CarNotFoundException(String message){
        super(message);
    }

    @Override
    public String getErrorCode(){
        return "Taki samochód nie istnieje";
    }
    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.BAD_REQUEST;
    }
}
