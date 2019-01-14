package com.example.starbucksorder.exception;

import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.exception.coustomexception.EntityNotFoundException;
import com.example.starbucksorder.exception.model.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestResponesExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseMsg entityNotFoundException(EntityNotFoundException ex){
        ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
        return responseMsg;
    }

    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseMsg entityAlreadyExistException(AlreadyExistException ex){
        ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
        return responseMsg;
    }


}
