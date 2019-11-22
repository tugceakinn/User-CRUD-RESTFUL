package com.example.restservice.h2.embedded.db.rest.crud.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String exceptionString) {
        super(exceptionString);
    }
}
