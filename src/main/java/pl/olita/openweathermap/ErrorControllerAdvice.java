package pl.olita.openweathermap;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(CityNotFoundException.class)
    public String catchException(){
        return "error";
    }
}
