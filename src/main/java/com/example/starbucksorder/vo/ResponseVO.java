package com.example.starbucksorder.vo;


import lombok.Data;

@Data
public class ResponseVO<T> {

    int code;

    String message;

    T response;

    public ResponseVO(int code,String message){
        this.code = code;
        this.message = message;
    }
}
