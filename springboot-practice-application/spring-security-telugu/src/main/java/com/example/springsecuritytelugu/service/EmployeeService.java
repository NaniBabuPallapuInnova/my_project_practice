package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Employee;
import com.example.springsecuritytelugu.mapper.EmployeeMapper;
import com.example.springsecuritytelugu.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

  public static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  EmployeeMapper employeeMapper;

  public List<EmployeeDTO> getAllEmployees() {
    List<Employee> employeeList = employeeRepository.findAll();

    List<EmployeeDTO> employeeDTOS = new ArrayList<>();

    employeeList.forEach(employee -> employeeDTOS.add(employeeMapper.toDTO(employee)));

    return employeeDTOS;
  }

  public void saveEmployee(EmployeeDTO employeeDTO) {
    Employee employee = employeeMapper.toEntity(employeeDTO);
    employeeRepository.save(employee);
    log.info("employee has been saved employee-details : {}", employee);
    String employeeId = "H" + (1000 + employee.getId());
    employee.setEmpId(employeeId);
    employeeRepository.save(employee);

  }

  public EmployeeDTO updateEmployeeDetails(Long id, EmployeeDTO employeeDTO){
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found"+id));
    employee.setName(employeeDTO.getName());
    employee.setEmail(employeeDTO.getEmail());
    employee.setPhone(employeeDTO.getPhone());
    employee.setSalary(employeeDTO.getSalary());
    employee.setDateOfJoining(employeeDTO.getDateOfJoining());
    employeeRepository.save(employee);
    EmployeeDTO updatedEmployeeDTO = employeeMapper.toDTO(employee);
    log.info("employee details have been updated id : {}, employee : {}",id, updatedEmployeeDTO);
    return updatedEmployeeDTO;
  }

  public EmployeeDTO findEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found"+id));
    EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);
    return employeeDTO;
  }

  public List<EmployeeDTO> findAllEmployees() {
    List<Employee> employeeList = employeeRepository.findAll();
    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    employeeList.forEach(employee -> employeeDTOList.add(employeeMapper.toDTO(employee)));
    return employeeDTOList;
  }

  public void deleteEmployeeById(Long id) {
    employeeRepository.deleteById(id);
  }
}
