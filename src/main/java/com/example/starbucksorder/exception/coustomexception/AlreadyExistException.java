package com.example.starbucksorder.exception.coustomexception;

import com.example.starbucksorder.exception.BaseException;

public class AlreadyExistException extends BaseException {

    public AlreadyExistException(String msg) {
        super(400, msg);
    }
}
