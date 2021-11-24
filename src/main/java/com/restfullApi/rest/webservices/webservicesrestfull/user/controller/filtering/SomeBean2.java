package com.restfullApi.rest.webservices.webservicesrestfull.user.controller.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"password"})
public class SomeBean2 {
  String usuario;
  //Para que este campo no se devuelva, podemos usar @JsonIgnoreProperties
  String password;
  String value3;

  public SomeBean2(String value1, String value2, String value3) {
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
