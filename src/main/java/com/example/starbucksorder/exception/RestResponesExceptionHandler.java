package com.example.starbucksorder.exception;

import com.example.starbucksorder.exception.coustomexception.AlreadyExistException;
import com.example.starbucksorder.exception.coustomexception.EntityNotFoundException;
import com.example.starbucksorder.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestResponesExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseBody
    public ResponseVO entityNotFoundException(EntityNotFoundException ex) {
        return new ResponseVO(401, ex.getMessage());
    }

    @ExceptionHandler(value = AlreadyExistException.class)
    @ResponseBody
    public ResponseVO entityAlreadyExistException(AlreadyExistException ex) {
        return new ResponseVO(400, ex.getMessage());
    }


}
