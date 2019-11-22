package com.example.restservice.h2.embedded.db.rest.crud.exception;

public class AlreadyExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public AlreadyExistException(String exceptionString) {
        super(exceptionString);
    }

}
