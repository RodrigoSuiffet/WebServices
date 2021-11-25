package com.restfullApi.rest.webservices.webservicesrestfull.user.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.Post;
import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.User;
import com.restfullApi.rest.webservices.webservicesrestfull.user.exception.UserNotFoundException;
import com.restfullApi.rest.webservices.webservicesrestfull.user.repository.PostRepository;
import com.restfullApi.rest.webservices.webservicesrestfull.user.repository.UserRepository;

@RestController
public class PostsController {

  @Autowired
  PostRepository postRepository;

  @Autowired
  UserRepository userRepository;


  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> allPost(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()){
      User defuser = user.get();
      return postRepository.findByUser(defuser);
    } else throw new UserNotFoundException("Id - " + id ,"Usuario no encontrado");

  }

}
