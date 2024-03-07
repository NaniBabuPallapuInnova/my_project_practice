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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements UserDetailsService {

  public static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  EmployeeMapper employeeMapper;

  @Autowired
  PasswordEncoder passwordEncoder;

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

  public EmployeeDTO updateEmployeeDetails(Long id, EmployeeDTO employeeDTO){
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found"+id));
    employee.setName(employeeDTO.getName());
    employee.setEmail(employeeDTO.getEmail());
    employee.setPhone(employeeDTO.getPhone());
    employee.setSalary(employeeDTO.getSalary());
    employee.setDateOfJoining(employeeDTO.getDateOfJoining());
    employeeRepository.save(employee);
    EmployeeDTO updatedEmployeeDTO = employeeMapper.toDTO(employee);
    log.info("employee details have been updated id : {}, employee : {}",id, updatedEmployeeDTO);
    return updatedEmployeeDTO;
  }

  public EmployeeDTO findEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found"+id));
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

  public List<EmployeeDTO> searchEmployeeByEmployeeIdOrName(String keyword) {
    List<Employee> employeeList = employeeRepository.findByNameContainingIgnoreCaseOrEmpIdContainingIgnoreCase(keyword, keyword);

    List<EmployeeDTO> employeeDTOS = new ArrayList<>();

    employeeList.forEach(employee -> employeeDTOS.add(employeeMapper.toDTO(employee)));
    return employeeDTOS;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Employee employee = employeeRepository.findByEmpId(username).orElseThrow(() -> new UsernameNotFoundException("USER DOES NOT EXIST WITH THIS EMPLOYEE ID" + username));

    EmployeeDTO employeeDTO = new EmployeeDTO();
    if (employee != null) {
      employeeDTO = employeeMapper.toDTO(employee);
    }
    return new User(
      employeeDTO.getEmpId(),
      passwordEncoder.encode(employeeDTO.getPassword()),
      employeeDTO.getActiveAccount(),
      true,
      true,
      true,
      getAuthorities(List.of(employeeDTO.getRole()))

    );
  }

  /**
   * Converts a list of roles to a collection of GrantedAuthority objects.
   *
   * @param roles The list of roles assigned to the user.
   * @return Collection of GrantedAuthority objects representing the Employee's roles.
   */
  private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();

    // Convert each role to a GrantedAuthority and add to the list of authorities.
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }

    return authorities;
  }

  public EmployeeDTO findByEmpId(String empId) {
    Employee employee =  employeeRepository.findByEmpId(empId)
      .orElseThrow(() -> new UsernameNotFoundException("EMPLOYEE NOT FOUND"));
   return employeeMapper.toDTO(employee);
  }
}
