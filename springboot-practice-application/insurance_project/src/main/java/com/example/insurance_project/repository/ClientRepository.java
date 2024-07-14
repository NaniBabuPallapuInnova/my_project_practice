package com.example.insurance_project.repository;


import com.example.insurance_project.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
