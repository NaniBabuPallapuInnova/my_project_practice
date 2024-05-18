package com.example.springsecuritytelugu.asyn.communication;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Employee;
import com.example.springsecuritytelugu.mapper.EmployeeMapper;
import com.example.springsecuritytelugu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class AsyncEmployeeService  {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  EmployeeMapper employeeMapper;
/*
  @Async
  public CompletableFuture<List<EmployeeDTO>> findAllEmployeesAsync() {
    return CompletableFuture.supplyAsync(() -> employeeRepository.findAll())
      .thenApply(employees -> employees.stream()
        .map(employeeMapper::toDTO)
        .collect(Collectors.toList())
      );
  }*/



  @Async
  public CompletableFuture<List<EmployeeDTO>> findAllEmployeesAsync() {
    return CompletableFuture.supplyAsync(() -> {
      List<Employee> employeeList = employeeRepository.findAll();
      return employeeList.stream()
        .map(employee -> {
          // Convert Employee to EmployeeDTO
          EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);
          // Add delay using Thread.sleep()
          try {
            Thread.sleep(1000); // Sleep for 1 second (adjust duration as needed)
          } catch (InterruptedException e) {
            System.out.println("Thread interrupted while sleeping");
            Thread.currentThread().interrupt();
          }
          return employeeDTO;
        })
        .collect(Collectors.toList());
    }).orTimeout(5, TimeUnit.SECONDS);
  }

}
