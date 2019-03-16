package com.petros.restserver.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AnimalNotFoundAdvice {

    @ExceptionHandler(AnimalNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String animalNotFound(AnimalNotFoundException exception){
        return exception.getMessage();
    }


}