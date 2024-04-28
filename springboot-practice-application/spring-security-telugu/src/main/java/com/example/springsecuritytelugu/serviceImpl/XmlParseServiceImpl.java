package com.example.springsecuritytelugu.serviceImpl;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.service.XmlParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class XmlParseServiceImpl implements XmlParseService {
  private final static Logger log = LoggerFactory.getLogger(XmlParseServiceImpl.class);


  @Value("${directory.files}")
  private String filesDirectory;


  @Override
  public EmployeeDTO XMLToObject(String xml) {

    EmployeeDTO employeeDTO;
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDTO.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      StringReader stringReader = new StringReader(xml);
     employeeDTO = (EmployeeDTO) unmarshaller.unmarshal(stringReader);
      log.info(employeeDTO.toString());

    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return employeeDTO;
  }

  @Override
  public String objectToXML(EmployeeDTO employeeDTO) {

    //      String fileName = UUID.randomUUID().toString().toLowerCase() + "." + "json";
    String fileName = employeeDTO.getName().replaceAll("\\s","")+"_"+"details"+"."+"xml";
    String filePath = filesDirectory + File.separator + fileName;

    File file = new File(filePath);
    StringWriter stringWriter = new StringWriter();
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDTO.class);
      Marshaller marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(employeeDTO, file);
      marshaller.marshal(employeeDTO, stringWriter);
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    log.info(stringWriter.toString());
    return stringWriter.toString();
  }
}
