package com.example.springsecuritytelugu.controller;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

  public static final Logger log = LoggerFactory.getLogger(EmployeeResource.class);

  @Autowired
  EmployeeService employeeService;

  @GetMapping("/employees")
  public ResponseEntity<List<EmployeeDTO>> getEmployeesList(){
    List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployees();

    return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
  }

  @PostMapping("/save/employee")
  public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
    employeeService.saveEmployee(employeeDTO);
    return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
  }

  @PutMapping("update/employee/{id}")
  public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDTO employeeDTO){
    EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployeeDetails(id, employeeDTO);
    return new ResponseEntity<>(updatedEmployeeDTO, HttpStatus.ACCEPTED);
  }

  @GetMapping("get/employee/{id}")
  public EmployeeDTO getEmployeeById(@PathVariable(name = "id")Long id){
    return employeeService.findEmployeeById(id);
  }

  @GetMapping("get/AllEmployees")
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
    List<EmployeeDTO> employeeDTOList = employeeService.findAllEmployees();
    return new ResponseEntity<>(employeeDTOList, HttpStatus.FOUND);
  }

  @DeleteMapping("delete/employee/{id}")
  public ResponseEntity<String> deleteEmployeeById(@PathVariable(name = "id")Long id){
    employeeService.deleteEmployeeById(id);
    return new ResponseEntity<>("DELETED", HttpStatus.OK);
  }
}
