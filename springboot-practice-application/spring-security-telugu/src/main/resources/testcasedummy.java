/*
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
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
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testSaveEmployee() {
    EmployeeDTO employeeDTO = new EmployeeDTO();
    employeeDTO.setName("John Doe");
    Employee employee = new Employee();
    employee.setName("John Doe");

    when(employeeMapper.toEntity(any())).thenReturn(employee);

    employeeService.saveEmployee(employeeDTO);

    verify(employeeRepository, times(1)).save(employee);
    verify(employeeMapper, times(1)).toEntity(employeeDTO);
  }

  @Test
  public void testUpdateEmployeeDetails() {
    Long id = 1L;
    EmployeeDTO employeeDTO = new EmployeeDTO();
    employeeDTO.setName("John Doe");

    Employee existingEmployee = new Employee();
    existingEmployee.setId(id);
    existingEmployee.setName("Old Name");

    when(employeeRepository.findById(id)).thenReturn(Optional.of(existingEmployee));
    when(employeeMapper.toDTO(existingEmployee)).thenReturn(employeeDTO);

    EmployeeDTO updatedEmployeeDTO = employeeService.updateEmployeeDetails(id, employeeDTO);

    Assert.assertEquals(employeeDTO.getName(), updatedEmployeeDTO.getName());
    verify(employeeRepository, times(1)).save(existingEmployee);
  }

  @Test(expected = NoSuchElementException.class)
  public void testUpdateEmployeeDetailsNotFound() {
    Long id = 1L;
    EmployeeDTO employeeDTO = new EmployeeDTO();

    when(employeeRepository.findById(id)).thenReturn(Optional.empty());

    employeeService.updateEmployeeDetails(id, employeeDTO);
  }

  @Test
  public void testFindEmployeeById() {
    Long id = 1L;
    EmployeeDTO employeeDTO = new EmployeeDTO();
    employeeDTO.setId(id);
    employeeDTO.setName("John Doe");

    Employee employee = new Employee();
    employee.setId(id);
    employee.setName("John Doe");

    when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
    when(employeeMapper.toDTO(employee)).thenReturn(employeeDTO);

    EmployeeDTO foundEmployee = employeeService.findEmployeeById(id);

    Assert.assertEquals(employeeDTO, foundEmployee);
  }

  @Test(expected = NoSuchElementException.class)
  public void testFindEmployeeByIdNotFound() {
    Long id = 1L;
    when(employeeRepository.findById(id)).thenReturn(Optional.empty());
    employeeService.findEmployeeById(id);
  }

  @Test
  public void testFindAllEmployees() {
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee());
    employeeList.add(new Employee());

    when(employeeRepository.findAll()).thenReturn(employeeList);

    List<EmployeeDTO> employeeDTOList = employeeService.findAllEmployees();

    Assert.assertEquals(employeeList.size(), employeeDTOList.size());
    verify(employeeMapper, times(employeeList.size())).toDTO(any());
  }

  @Test
  public void testDeleteEmployeeById() {
    Long id = 1L;
    employeeService.deleteEmployeeById(id);
    verify(employeeRepository, times(1)).deleteById(id);
  }

  @Test
  public void testSearchEmployeeByEmployeeIdOrName() {
    String keyword = "John";
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee());

    when(employeeRepository.findByNameContainingIgnoreCaseOrEmpIdContainingIgnoreCase(keyword, keyword)).thenReturn(employeeList);

    List<EmployeeDTO> employeeDTOList = employeeService.searchEmployeeByEmployeeIdOrName(keyword);

    Assert.assertEquals(employeeList.size(), employeeDTOList.size());
    verify(employeeMapper, times(employeeList.size())).toDTO(any());
  }

  @Test
  public void testSearchEmployeeByEmployeeIdOrNameWithEmail() {
    String keyword = "john@gmail.com";
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee());

    when(employeeRepository.findByNameContainingIgnoreCaseOrEmpIdContainingIgnoreCase(keyword, keyword)).thenReturn(new ArrayList<>());

    StoredProcedureQuery storedProcedureQuery = mock(StoredProcedureQuery.class);
    when(entityManager.createNamedStoredProcedureQuery("SearchEmployees")).thenReturn(storedProcedureQuery);
    when(storedProcedureQuery.setParameter("emp_email", keyword)).thenReturn(storedProcedureQuery);
    when(storedProcedureQuery.execute()).thenReturn(true);
    when(storedProcedureQuery.getResultList()).thenReturn(employeeList);

    List<EmployeeDTO> employeeDTOList = employeeService.searchEmployeeByEmployeeIdOrName(keyword);

    Assert.assertEquals(employeeList.size(), employeeDTOList.size());
    verify(employeeMapper, times(employeeList.size())).toDTO(any());
  }


  @Test
public void testGetAllEmployees() {
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee());
    employeeList.add(new Employee());

    Pageable pageable = PageRequest.of(0, 10);
    Page<Employee> employeePage = new PageImpl<>(employeeList, pageable, employeeList.size());

    when(employeeRepository.findAll(pageable)).thenReturn(employeePage);

    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    employeeList.forEach(employee -> employeeDTOList.add(employeeMapper.toDTO(employee)));

    Page<EmployeeDTO> expectedPage = new PageImpl<>(employeeDTOList, pageable, employeeList.size());

    Page<EmployeeDTO> actualPage = employeeService.getAllEmployees(pageable);

    Assert.assertEquals(expectedPage.getContent().size(), actualPage.getContent().size());
    Assert.assertEquals(expectedPage.getTotalElements(), actualPage.getTotalElements());
    Assert.assertEquals(expectedPage.getTotalPages(), actualPage.getTotalPages());
    Assert.assertEquals(expectedPage.getPageable(), actualPage.getPageable());

    // Ensure that EmployeeDTO objects in both pages are equal
    for (int i = 0; i < expectedPage.getContent().size(); i++) {
        EmployeeDTO expectedDTO = expectedPage.getContent().get(i);
        EmployeeDTO actualDTO = actualPage.getContent().get(i);
        Assert.assertEquals(expectedDTO.getId(), actualDTO.getId());
        // Add more assertions for other fields if necessary
    }

    verify(employeeRepository, times(1)).findAll(pageable);
}

}
*/
