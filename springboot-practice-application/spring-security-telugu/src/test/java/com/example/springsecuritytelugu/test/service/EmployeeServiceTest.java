package com.example.springsecuritytelugu.test.service;

import com.example.springsecuritytelugu.service.EmployeeService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Autowired
  private EmployeeService employeeService;

}
