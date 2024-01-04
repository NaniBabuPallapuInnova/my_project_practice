package com.example.springsecuritytelugu.mapper;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
  @Override
  public EmployeeDTO toDTO(Employee employee) {
    if (employee == null) {
      return null;
    }
    EmployeeDTO employeeDTO = new EmployeeDTO();
    employeeDTO.setId(employee.getId());
    employeeDTO.setName(employee.getName());
    employeeDTO.setEmail(employee.getEmail());
    employeeDTO.setPhone(employee.getPhone());
    employeeDTO.setSalary(employee.getSalary());
    employeeDTO.setEmpId(employee.getEmpId());
    employeeDTO.setDateOfJoining(employee.getDateOfJoining());
    return employeeDTO;
  }

  @Override
  public Employee toEntity(EmployeeDTO employeeDTO) {
    if (employeeDTO == null) {
      return null;
    }
    Employee employee = new Employee();
    employee.setId(employeeDTO.getId());
    employee.setName(employeeDTO.getName());
    employee.setEmail(employeeDTO.getEmail());
    employee.setPhone(employeeDTO.getPhone());
    employee.setSalary(employeeDTO.getSalary());
    employee.setEmpId(employeeDTO.getEmpId());
    employee.setDateOfJoining(employeeDTO.getDateOfJoining());
    return employee;

  }
}
