package com.example.restservice.h2.embedded.db.rest.crud.controller;


import com.example.restservice.h2.embedded.db.rest.crud.exception.AlreadyExistException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.BadRequestException;
import com.example.restservice.h2.embedded.db.rest.crud.exception.NotFoundException;
import com.example.restservice.h2.embedded.db.rest.crud.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
		LOG.error("[handleNotFoundException] Exception: {}", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(AlreadyExistException.class)
	@ResponseBody
	public ResponseEntity<?> handleAlreadyException(AlreadyExistException ex) {
		LOG.error("[handleNotFoundException] Exception: {}", ex.getMessage());
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public ResponseEntity<?> handleBadRequestException(BadRequestException ex) {
		LOG.error("[BadRequestException] Exception: {}", ex.getMessage());
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
		LOG.error("[handleNotFoundException] Exception: {}", ex.getBindingResult().getFieldErrors());
		Iterator ite = ex.getBindingResult().getFieldErrors().iterator();
		String exceptionString = null;
		while (ite.hasNext()) {
			FieldError err = (FieldError) ite.next();
			exceptionString = exceptionString != null ? Utils.addFieldValidationException(exceptionString, err.getDefaultMessage()) : err.getDefaultMessage();
		}
		return ResponseEntity.badRequest().body(exceptionString);
	}

}
