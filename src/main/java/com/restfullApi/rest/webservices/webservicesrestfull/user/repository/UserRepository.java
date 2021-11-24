package com.restfullApi.rest.webservices.webservicesrestfull.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfullApi.rest.webservices.webservicesrestfull.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {



}
