package ru.tenilin.authorizationservice.service;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
