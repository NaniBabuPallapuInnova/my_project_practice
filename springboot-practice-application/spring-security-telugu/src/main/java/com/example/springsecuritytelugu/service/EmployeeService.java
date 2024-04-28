package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Employee;
import com.example.springsecuritytelugu.mapper.EmployeeMapper;
import com.example.springsecuritytelugu.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

  public static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
  public static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b";

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  EmployeeMapper employeeMapper;

  @Autowired
  EntityManager entityManager;

  @Autowired
  JSONParserService jsonParserService;

  @Autowired
  XmlParseService xmlParseService;

  public Page<EmployeeDTO> getAllEmployees(Pageable pageable) {
    Page<Employee> employeePage = employeeRepository.findAll(pageable);

    List<EmployeeDTO> employeeDTOS = new ArrayList<>();

    employeePage.getContent().forEach(employee -> employeeDTOS.add(employeeMapper.toDTO(employee)));

    return new PageImpl<>(employeeDTOS, pageable, employeePage.getTotalElements());
  }

  public void saveEmployee(EmployeeDTO employeeDTO) {
    Employee employee = employeeMapper.toEntity(employeeDTO);
    employeeRepository.save(employee);
    log.info("employee has been saved employee-details : {}", employee);
    String employeeId = "H" + (1000 + employee.getId());
    employee.setEmpId(employeeId);
    employeeRepository.save(employee);

  }

  public EmployeeDTO updateEmployeeDetails(Long id, EmployeeDTO employeeDTO) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found" + id));
    employee.setName(employeeDTO.getName());
    employee.setEmail(employeeDTO.getEmail());
    employee.setPhone(employeeDTO.getPhone());
    employee.setSalary(employeeDTO.getSalary());
    employee.setDateOfJoining(employeeDTO.getDateOfJoining());
    employeeRepository.save(employee);
    EmployeeDTO updatedEmployeeDTO = employeeMapper.toDTO(employee);
    log.info("employee details have been updated id : {}, employee : {}", id, updatedEmployeeDTO);
    return updatedEmployeeDTO;
  }

  public EmployeeDTO findEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found" + id));
    EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);

    return employeeDTO;
  }

  public List<EmployeeDTO> findAllEmployees() {
    List<Employee> employeeList = employeeRepository.findAll();
    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    employeeList.forEach(employee -> employeeDTOList.add(employeeMapper.toDTO(employee)));
    return employeeDTOList;
  }

  public void deleteEmployeeById(Long id) {
    employeeRepository.deleteById(id);
  }


  /**
   * Searches for employees by either name or employee ID, and optionally by email using a stored procedure.
   *
   * @param keyword The search keyword to match against employee names, IDs, or emails.
   * @return A list of EmployeeDTO objects representing the matched employees.
   */
  @Transactional(rollbackFor = Exception.class)
  public List<EmployeeDTO> searchEmployeeByEmployeeIdOrName(String keyword) {
    List<Employee> employeeList = employeeRepository.findByNameContainingIgnoreCaseOrEmpIdContainingIgnoreCase(keyword, keyword);

    if (keyword.matches(EMAIL_REGEX)) {
      StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("SearchEmployees");
      storedProcedureQuery.setParameter("emp_email", keyword);

      // Execute the stored procedure query
      List<Employee> resultList = storedProcedureQuery.execute() ? storedProcedureQuery.getResultList() : Collections.emptyList();
      employeeList.addAll(resultList);
    }

    List<EmployeeDTO> employeeDTOS = new ArrayList<>();
    employeeList.forEach(employee -> employeeDTOS.add(employeeMapper.toDTO(employee)));
    return employeeDTOS;
  }


  public EmployeeDTO downloadEmployeeAsJSONFile(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found" + id));
    EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);

    // converting Java Object into JSON String and download file
    String jsonString = jsonParserService.objectToJson(employeeDTO);

    //converting JSON string into Java Object
    jsonParserService.jsonToObject(jsonString);
    return employeeDTO;
  }

  public EmployeeDTO downloadEmployeeAsXMLFile(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found" + id));
    EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);

    // converting object into xml and print on console
    String xmlString = xmlParseService.objectToXML(employeeDTO);

    employeeDTO = xmlParseService.XMLToObject(xmlString);

    return employeeDTO;
  }


}
