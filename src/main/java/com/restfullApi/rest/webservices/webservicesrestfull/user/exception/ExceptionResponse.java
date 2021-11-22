package com.restfullApi.rest.webservices.webservicesrestfull.user.exception;

import java.util.Date;


public class ExceptionResponse {
  private Date timestamp;
  private String mesage;
  private String details;


  public ExceptionResponse(Date timestamp, String mesage, String details) {
    super();
    this.timestamp = timestamp;
    this.mesage = mesage;
    this.details = details;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMesage() {
    return mesage;
  }

  public String getDetails() {
    return details;
  }
}
