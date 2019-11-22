package com.example.restservice.h2.embedded.db.rest.crud.exception;

public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1L;

    public BadRequestException(String exceptionString) {
        super(exceptionString);
    }

}
