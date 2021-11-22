package com.restfullApi.rest.webservices.webservicesrestfull.user.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.User;
import com.restfullApi.rest.webservices.webservicesrestfull.user.services.UserDaoService;
import com.restfullApi.rest.webservices.webservicesrestfull.user.exception.UserNotFoundException;

@RestController
public class UserController {

  @Autowired
  private UserDaoService service;

  @GetMapping (path = "/users")
  public List<User> retrieveAllUsers() {
    return service.findAll();
  }

  @GetMapping (path = "/users/{id}")
  public User retrieveOneUser(@PathVariable Integer id) {
    User user = service.findOne(id);
    if (user==null){
      throw new UserNotFoundException("id - " + id, "No se ha encontrado el usuario con el ID indicado.");
    }
    return user;
  }

  @DeleteMapping (path = "/users/{id}")
  public User removeUserById(@PathVariable Integer id) {
    User user = service.deleteById(id);
    if (user==null){
      throw new UserNotFoundException("id - " + id, "No se ha encontrado el usuario con el ID indicado.");
    }
    return user;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser (@RequestBody User user) {
    User savedUser = service.save(user);
    URI location =
        ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

}
