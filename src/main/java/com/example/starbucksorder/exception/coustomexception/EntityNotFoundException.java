package com.example.starbucksorder.exception.coustomexception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg){
        super(msg);
    }
}
