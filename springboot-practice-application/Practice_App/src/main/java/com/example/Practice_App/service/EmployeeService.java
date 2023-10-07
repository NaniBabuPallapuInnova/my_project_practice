package com.example.Practice_App.service;

import com.example.Practice_App.domain.Employee;
import com.example.Practice_App.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public Employee findEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<Employee> findAllEmployeesById(List<Long> id){
        return employeeRepository.findAllById(id);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public void deleteAllEmployee(){
        employeeRepository.deleteAll();
    }



}
