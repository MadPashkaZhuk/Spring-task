package com.zhukpaul.spring.springboot.innowise.exceptions;

public class NoSuchProjectException extends RuntimeException{
    public NoSuchProjectException(String message) {
        super(message);
    }
}
