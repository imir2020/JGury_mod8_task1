package by.javagur.spring.http.handler;

import by.javagur.spring.http.exception.AgeException;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AgeException.class)
    public String handlerAgeException(Exception exception){
        log.error("Failed to age ", exception);
        return "error/error_age";
    }
}
