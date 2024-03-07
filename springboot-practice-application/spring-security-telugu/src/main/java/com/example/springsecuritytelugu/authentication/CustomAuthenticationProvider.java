package com.example.springsecuritytelugu.authentication;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Attempts;
import com.example.springsecuritytelugu.service.AttemptsService;
import com.example.springsecuritytelugu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private static final int ATTEMPTS_LIMIT = 3;

  @Autowired
   EmployeeService employeeService;

  @Autowired
   AttemptsService attemptsService;

  @Autowired
   PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String empId = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserDetails userDetails = employeeService.loadUserByUsername(empId);

    if (passwordEncoder.matches(password, userDetails.getPassword())) {
      // Authentication successful
      resetLoginAttempts(empId);
      return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    } else {
      // Authentication failed
      handleFailedAttempts(empId, userDetails);
      throw new BadCredentialsException("INVALID CREDENTIALS");
    }
  }

  private void handleFailedAttempts(String empId, UserDetails userDetails) {
    Optional<Attempts> attempts = attemptsService.findByUsername(empId);

    if (attempts.isEmpty()) {
      Attempts attempt = new Attempts();
      attempt.setEmpId(empId);
      attempt.setCount(1);
      attemptsService.saveAttempts(attempt);
    } else {
      Attempts attempt = attempts.get();
      attempt.setCount(attempt.getCount() + 1);
      attemptsService.saveAttempts(attempt);
      if (attempt.getCount() > ATTEMPTS_LIMIT) {
        EmployeeDTO employee = employeeService.findByEmpId(empId);

        employee.setActiveAccount(false);
        employeeService.saveEmployee(employee);
        throw new LockedException("Too many invalid attempts. Account is locked!!");
      }
    }
  }

  private void resetLoginAttempts(String empId) {
    Optional<Attempts> userAttempts = attemptsService.findByUsername(empId);
    userAttempts.ifPresent(attempts -> {
      attempts.setCount(0);
      attemptsService.saveAttempts(attempts);
    });
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

}


