package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.entity.Role;
import com.example.springsecuritytelugu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;
  public Role createNewRole(Role role){
    return roleRepository.save(role);
  }
}
