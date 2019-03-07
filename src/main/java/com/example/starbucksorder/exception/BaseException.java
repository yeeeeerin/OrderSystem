package com.example.starbucksorder.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {

    private int status;

    private int msg;

    public BaseException(int status, String msg) {
        super(msg);
        this.status = status;
    }
}
