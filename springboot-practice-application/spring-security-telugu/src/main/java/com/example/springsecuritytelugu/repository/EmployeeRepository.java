package com.example.springsecuritytelugu.repository;

import com.example.springsecuritytelugu.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCaseOrEmpIdContainingIgnoreCase(String keyword, String keyword1);

    Optional<Employee> findByEmpId(String empId);
}
