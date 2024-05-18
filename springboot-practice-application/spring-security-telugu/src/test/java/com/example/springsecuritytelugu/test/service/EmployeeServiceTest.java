package com.example.springsecuritytelugu.test.service;

import com.example.springsecuritytelugu.dto.EmployeeDTO;
import com.example.springsecuritytelugu.entity.Employee;
import com.example.springsecuritytelugu.mapper.EmployeeMapper;
import com.example.springsecuritytelugu.repository.EmployeeRepository;
import com.example.springsecuritytelugu.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

  @Mock
  private EmployeeRepository employeeRepository;

  @Mock
  private EmployeeMapper employeeMapper;

  @InjectMocks
  private EmployeeService employeeService;

  @Before
  public void setUp(){
    MockitoAnnotations.openMocks(this);
  }


  @Test
  public void testSaveEmployee(){
    EmployeeDTO employeeDTO = new EmployeeDTO(101L,"1001","Nani","welcome@gmail.com","Hyderabad",true,"9876543210",35000.50,"25-09-1998");

    Employee employee = new Employee(101L,"1001","Nani","welcome@gmail.com","Hyderabad",true,"9876543210",35000.50,"25-09-1998");

    when(employeeMapper.toEntity(any(EmployeeDTO.class))).thenReturn(employee);

    employeeService.saveEmployee(employeeDTO);
    verify(employeeRepository, times(2)).save(employee);
    verify(employeeMapper, times(1)).toEntity(employeeDTO);

  }

  @Test
  public void testUpdateEmployeeDetails(){
    Long id  = 101L;
    EmployeeDTO employeeDTO = new EmployeeDTO(101L,"1001","Babu","pallapu@gmail.com","Hyderabad@369",true,"1234567890",15000.50,"25-09-1999");
    Employee existingEmployee = new Employee(101L,"1001","Nani","welcome@gmail.com","Hyderabad",true,"9876543210",35000.50,"25-09-1998");

    when(employeeRepository.findById(id)).thenReturn(Optional.of(existingEmployee));

    when(employeeMapper.toDTO(existingEmployee)).thenReturn(employeeDTO);

    EmployeeDTO updatedEmployee = employeeService.updateEmployeeDetails(id, employeeDTO);
    System.out.println(updatedEmployee.toString());

    Assert.assertEquals(employeeDTO.getName(), updatedEmployee.getName());
    verify(employeeRepository, times(1)).save(existingEmployee);

  }

}
