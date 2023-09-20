package com.example.Practice_App.mappings;

import com.example.Practice_App.domain.Employee;
import com.example.Practice_App.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeDTO toDto(Employee employee);

    Employee toEntity(EmployeeDTO employeeDTO);
}
