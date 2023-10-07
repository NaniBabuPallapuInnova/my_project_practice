package com.example.Practice_App.controller;


import com.example.Practice_App.domain.Employee;
import com.example.Practice_App.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/add-employee")
    public @ResponseBody String saveEmployeeType1(@RequestParam(name = "name", defaultValue = "Divya")String name, @RequestParam(name = "salary") double salary, @RequestParam String companyName){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setCompanyName(companyName);
        employeeService.saveEmployee(employee);
        return "SAVED";
    }

    @PostMapping("/add-employee-type2")
    public HttpStatus saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return HttpStatus.ACCEPTED;
    }

    @PostMapping("/save-all-employees")
    public List<Employee> saveAllEmployees(@RequestBody List<Employee> employeeList){
        List<Employee> employees = employeeService.saveAllEmployees(employeeList);
        return employees;
    }

    @GetMapping("/display-employees")
    public List<Employee> displayAllEmployees(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employee-by-id/{id}")
    public Employee displayEmployeeById(@PathVariable("id")Long id){
        return employeeService.findEmployee(id);
    }

    @PostMapping("/update-employee/{id}")
    public Employee updateEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.findEmployee(id);
        employee.setName("Nani");
        employee.setSalary(40000.90);
        employee.setCompanyName("ACS SOLUTIONS");
        return employee;
    }

    @PostMapping("/update-employee-body/{id}")
    public Employee updateEmployeeByEmployeeId(@RequestBody Employee employee, @PathVariable("id") Long id){
        Employee employee1 = employeeService.findEmployee(id);

        /*

        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        employee1.setCompanyName(employee.getCompanyName());
        employeeService.saveEmployee(employee1);

        */

        employee.setId(employee1.getId());
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @DeleteMapping("/delete-all-employees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployee();
    }

}
