package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.entity.Attempts;
import com.example.springsecuritytelugu.repository.AttemptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AttemptsService  {

  @Autowired
  AttemptsRepository attemptsRepository;

  public Optional<Attempts> findByUsername(String empId){
    return attemptsRepository.findByEmpId(empId);
//                        .orElseThrow(() -> new EntityNotFoundException("Not Found"+empId));
  }

  public void saveAttempts(Attempts attempts){
    attemptsRepository.save(attempts);
  }
}
