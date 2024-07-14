package com.example.insurance_project.repository;

import com.example.insurance_project.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>{

}