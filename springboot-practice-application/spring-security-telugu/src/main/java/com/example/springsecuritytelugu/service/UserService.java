package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.entity.Role;
import com.example.springsecuritytelugu.entity.User;
import com.example.springsecuritytelugu.repository.RoleRepository;
import com.example.springsecuritytelugu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;


  @Autowired
  private PasswordEncoder passwordEncoder;

  public User registerNewUser(User user) {

    Role role = roleRepository.findById("user").get();

    Set<Role> roles = new HashSet<>();
    roles.add(role);
    user.setRoles(roles);
    user.setUserPassword(getEncodedPassword(user.getUserPassword()));

    return userRepository.save(user);
  }

  public void initRolesAndUser(){
    Role adminRole = new Role();
    adminRole.setRoleName("admin");
    adminRole.setRoleDescription("admin role for application");
    roleRepository.save(adminRole);

    Role userRole = new Role();
    userRole.setRoleName("user");
    userRole.setRoleDescription("default role for newly created user for application");
    roleRepository.save(userRole);

    User adminUser = new User();
    adminUser.setUserFirstName("admin");
    adminUser.setUserLastName("admin");
    adminUser.setUserName("admin123");
    adminUser.setUserPassword(getEncodedPassword("admin@password"));
    Set<Role> rolesForAdmin = new HashSet<>();
    rolesForAdmin.add(adminRole);
    adminUser.setRoles(rolesForAdmin);
    userRepository.save(adminUser);

/*

    User userOnly = new User();
    userOnly.setUserFirstName("Nani");
    userOnly.setUserLastName("Pallapu");
    userOnly.setUserName("Nani Pallapu");
    userOnly.setUserPassword(getEncodedPassword("Hyderabad@369"));
    Set<Role> rolesForUser = new HashSet<>();
    rolesForUser.add(userRole);
    userOnly.setRoles(rolesForUser);
    userRepository.save(userOnly);

*/

  }

  public String getEncodedPassword(String password){
    return passwordEncoder.encode(password);
  }
}
