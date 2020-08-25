package nl.Eindopdracht.BoogieWoogie.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PropNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PropNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String propNotFoundHandler(PropNotFoundException ex) {
        return ex.getMessage();
    }
}
