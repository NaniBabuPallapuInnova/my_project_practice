package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface XmlParseService {

   EmployeeDTO XMLToObject(String xml);

   String objectToXML(EmployeeDTO employeeDTO);



}
