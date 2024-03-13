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


  @PostMapping("/authenticate")
  public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {

    return jwtService.createJwtToken(jwtRequest);

  }
}
