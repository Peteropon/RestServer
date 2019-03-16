package com.petros.restserver.util;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id){
        super("Animal with id: " + id + " is not found.");
    }

}
