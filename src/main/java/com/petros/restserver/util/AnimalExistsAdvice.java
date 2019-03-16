package com.petros.restserver.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AnimalExistsAdvice {
    @ExceptionHandler(AnimalExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public String animalExistsHandler(AnimalExistsException ae){
        return ae.getMessage();
    }
}
