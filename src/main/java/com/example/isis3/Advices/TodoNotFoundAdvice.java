package com.example.isis3.Advices;

import com.example.isis3.Errors.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TodoNotFoundAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity handleError(TodoNotFoundException ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
