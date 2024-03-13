package com.example.springsecuritytelugu.controller;

import com.example.springsecuritytelugu.entity.Role;
import com.example.springsecuritytelugu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleResource {

  @Autowired
  private RoleService roleService;

  @PostMapping("/createNewRole")
  public Role createNewRole(@RequestBody Role role){
    return roleService.createNewRole(role);
  }
}
