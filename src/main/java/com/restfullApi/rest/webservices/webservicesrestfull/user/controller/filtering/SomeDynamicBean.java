package com.restfullApi.rest.webservices.webservicesrestfull.user.controller.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeDynamicBeanFilter")
public class SomeDynamicBean {

  String usuario;
  String password;
  String value3;

  public SomeDynamicBean(String value1, String value2, String value3) {
    this.usuario = value1;
    this.password = value2;
    this.value3 = value3;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getValue3() {
    return value3;
  }

  public void setValue3(String value3) {
    this.value3 = value3;
  }
}

