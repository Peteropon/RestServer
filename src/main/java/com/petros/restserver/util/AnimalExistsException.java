package com.petros.restserver.util;

public class AnimalExistsException extends RuntimeException {
    public AnimalExistsException(String s){
        super(s);
    }

}
