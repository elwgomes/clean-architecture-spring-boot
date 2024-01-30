package br.com.elwgomes.registerapi.infra.user.controller.exception;

import br.com.elwgomes.registerapi.core.user.exception.FieldCantBeNullException;
import br.com.elwgomes.registerapi.core.user.exception.UserAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> UserAlreadyExistsHandler (UserAlreadyExistsException exception) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(FieldCantBeNullException.class)
    public ResponseEntity<ExceptionResponse> FieldCantBeNullHandler (FieldCantBeNullException exception) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
