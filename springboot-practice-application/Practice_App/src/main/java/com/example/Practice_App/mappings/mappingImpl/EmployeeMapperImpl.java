package com.example.Practice_App.mappings.mappingImpl;

import com.example.Practice_App.domain.Employee;
import com.example.Practice_App.dto.EmployeeDTO;
import com.example.Practice_App.mappings.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeDTO toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setCompanyName(employee.getCompanyName());
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
        employee.setCompanyName(employeeDTO.getCompanyName());
        return employee;
    }
}
