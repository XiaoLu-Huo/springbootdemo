package com.example.springbootDemo.exception;

import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResult> handle(NotFoundException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResult errorResult = new ErrorResult(status.value(), ex.getMessage());
        return ResponseEntity.status(status).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(";"));
        ErrorResult errorResult = new ErrorResult(status.value(), message);
        return ResponseEntity.status(status).body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(";"));
        ErrorResult errorResult = new ErrorResult(status.value(), message);
        return ResponseEntity.status(status).body(errorResult);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> handle(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResult errorResult = new ErrorResult(status.value(), ex.getMessage());
        return ResponseEntity.status(status).body(errorResult);
    }
}
