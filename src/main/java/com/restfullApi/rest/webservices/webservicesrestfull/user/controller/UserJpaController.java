package com.restfullApi.rest.webservices.webservicesrestfull.user.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.User;
import com.restfullApi.rest.webservices.webservicesrestfull.user.exception.UserNotFoundException;
import com.restfullApi.rest.webservices.webservicesrestfull.user.repository.UserRepository;
import com.restfullApi.rest.webservices.webservicesrestfull.user.services.UserDaoService;

@RestController
public class UserJpaController {

  @Autowired
  private UserRepository userRepository;
  
  @GetMapping(path = "/jpa/users")
  public List<User> retrieveAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping (path = "/jpa/users/{id}")
  public EntityModel<User> retrieveOneUser(@PathVariable Integer id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()){
      throw new UserNotFoundException("id - " + id, "No se ha encontrado el usuario con el ID indicado.");
    }
    EntityModel<User> model = EntityModel.of(user.get());

    WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
    model.add(linkToUsers.withRel("All-users"));
    return model;
  }

  @DeleteMapping(path = "/jpa/users/{id}")
  public void removeUserById(@PathVariable Integer id) {
    userRepository.deleteById(id);
  }

  @PostMapping("/jpa/users")
  public ResponseEntity<Object> createUser (@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);
    URI location =
        ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

}
