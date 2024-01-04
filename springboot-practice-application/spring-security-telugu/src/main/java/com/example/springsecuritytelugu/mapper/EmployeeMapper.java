package com.example.springsecuritytelugu.mapper;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  EmployeeDTO toDTO(Employee employee);

  Employee toEntity(EmployeeDTO employeeDTO);
}
