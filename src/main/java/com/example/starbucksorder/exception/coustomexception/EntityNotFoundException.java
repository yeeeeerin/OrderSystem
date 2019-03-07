package com.example.starbucksorder.exception.coustomexception;

import com.example.starbucksorder.exception.BaseException;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(String msg) {
        super(401, msg);
    }
}
