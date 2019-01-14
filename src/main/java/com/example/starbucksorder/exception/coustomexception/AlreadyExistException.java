package com.example.starbucksorder.exception.coustomexception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String msg){
        super(msg);
    }
}
