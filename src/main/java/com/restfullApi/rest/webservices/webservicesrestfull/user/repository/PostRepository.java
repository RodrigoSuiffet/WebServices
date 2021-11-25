package com.restfullApi.rest.webservices.webservicesrestfull.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.Post;
import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.User;

@Repository
public interface PostRepository  extends JpaRepository<Post,Integer> {

  List<Post> findByUser(User user);

}
