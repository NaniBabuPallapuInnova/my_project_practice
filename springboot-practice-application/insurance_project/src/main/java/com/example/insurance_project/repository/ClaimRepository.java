package com.example.insurance_project.repository;

import com.example.insurance_project.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;


@Component
public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}