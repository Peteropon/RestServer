package com.petros.restserver.util;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String notFound){
        super(notFound);
    }

}
