package com.petros.restserver.util;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String not_found){
        super(not_found);
    }

}
