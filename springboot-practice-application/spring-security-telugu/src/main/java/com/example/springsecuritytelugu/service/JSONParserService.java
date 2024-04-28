package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface JSONParserService {

  EmployeeDTO jsonToObject(String json);

  String objectToJson(EmployeeDTO employeeDTO);
}
