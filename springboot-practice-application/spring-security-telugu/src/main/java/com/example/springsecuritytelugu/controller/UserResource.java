package com.example.springsecuritytelugu.controller;

import com.example.springsecuritytelugu.entity.User;
import com.example.springsecuritytelugu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

  @Autowired
  private UserService userService;

  @PostMapping("/dummyData")
  public void insertDummyDataForTables(){
    userService.initRolesAndUser();
  }

  @PostMapping("/registerNewUser")
  public User registerNewUser(@RequestBody User user){
    return userService.registerNewUser(user);
  }

  @GetMapping("/forAdmin")
  @PreAuthorize("hasRole('admin')")
  public String accessOnlyForAdmin(){
    return "This endpoint is accessible for ADMIN only";
  }

  @GetMapping("/forUser")
  @PreAuthorize("hasRole('user')")
//  @PreAuthorize("hasAnyRole('user','admin')") --> if user has more than 1 role 
  public String accessOnlyForUser(){

    return "This endpoint is accessible for USER only";
  }



}
