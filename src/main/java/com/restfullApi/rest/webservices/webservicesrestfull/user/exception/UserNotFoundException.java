package com.restfullApi.rest.webservices.webservicesrestfull.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
 String details;
  public UserNotFoundException(String message, String details) {
    super(message);
    this.details = details;
  }

  public String getDetails() {
    return details;
  }
}
