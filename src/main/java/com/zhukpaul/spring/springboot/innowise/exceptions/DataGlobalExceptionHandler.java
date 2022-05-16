package com.zhukpaul.spring.springboot.innowise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectDataHandler> handleException(NoSuchProjectException exception) {
        IncorrectDataHandler data = new IncorrectDataHandler();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectDataHandler> handleException(Exception exception) {
        IncorrectDataHandler data = new IncorrectDataHandler();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
