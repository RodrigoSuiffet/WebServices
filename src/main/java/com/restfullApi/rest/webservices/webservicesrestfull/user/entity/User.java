package com.restfullApi.rest.webservices.webservicesrestfull.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;

import lombok.Data;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue
  private Integer id;

  @Size(min=2, message = "El nombre debe tener al menos dos caracteres.")
  private String name;

  @Past
  private Date birthDate;

  @OneToMany(mappedBy="user")
  private List<Post> posts;




  public User() {

  }
  public User(Integer id, String name, Date birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  @Override public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthDate=" + birthDate +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}
