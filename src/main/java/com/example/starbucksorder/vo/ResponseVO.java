package com.example.starbucksorder.vo;


import lombok.Data;

@Data
public class ResponseVO<T> {

    int status;

    String message;

    T response;

    public ResponseVO(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
