package com.example.springsecuritytelugu.serviceImpl;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.service.JSONParserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

@Service
public class JSONParserServiceImpl implements JSONParserService {

  private final static Logger log = LoggerFactory.getLogger(JSONParserServiceImpl.class);

  @Value("${directory.files}")
  private String filesDirectory;

  @Override
  public EmployeeDTO jsonToObject(String json) {

    ObjectMapper objectMapper = new ObjectMapper();

    EmployeeDTO employeeDTO;
    try {
      employeeDTO = objectMapper.readValue(json, EmployeeDTO.class);
      log.info(employeeDTO.toString());
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return employeeDTO;
  }

  @Override
  public String objectToJson(EmployeeDTO employeeDTO) {

    ObjectMapper objectMapper = new ObjectMapper();

    String json = null;
    try {
      json = objectMapper.writeValueAsString(employeeDTO);

//      String fileName = UUID.randomUUID().toString().toLowerCase() + "." + "json";
      String fileName = employeeDTO.getName().replaceAll("\\s","")+"_"+"details"+"."+"json";
      String filePath = filesDirectory + File.separator + fileName;
      log.info(filePath);

      File file = new File(filePath);
      objectMapper.writeValue(file, json);
      log.info(json);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return json;
  }
}
