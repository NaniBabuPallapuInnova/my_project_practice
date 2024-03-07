package com.example.springsecuritytelugu.repository;

import com.example.springsecuritytelugu.entity.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Long> {

  Optional<Attempts> findByEmpId(String empId);
}
