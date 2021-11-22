package com.restfullApi.rest.webservices.webservicesrestfull.user.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UserResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException
      (Exception ex, WebRequest request) throws Exception {
    ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> handleUserNotFoundException
      (UserNotFoundException ex, WebRequest request) throws Exception {
    ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), ex.getDetails());
    return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
  }

}