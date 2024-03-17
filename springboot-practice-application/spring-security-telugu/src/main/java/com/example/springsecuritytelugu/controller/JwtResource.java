package com.example.springsecuritytelugu.controller;

import com.example.springsecuritytelugu.entity.JwtRequest;
import com.example.springsecuritytelugu.entity.JwtResponse;
import com.example.springsecuritytelugu.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtResource {

  @Autowired
  @Lazy
  private JwtService jwtService;


  /**
   * Controller method to authenticate a user and generate a JWT token.
   *
   * @param jwtRequest The JWT request containing user credentials
   * @return The JWT response containing the user details and generated token
   * @throws Exception If an error occurs during token generation
   */
  @PostMapping("/authenticate")
  public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    return jwtService.createJwtToken(jwtRequest);
  }
}
