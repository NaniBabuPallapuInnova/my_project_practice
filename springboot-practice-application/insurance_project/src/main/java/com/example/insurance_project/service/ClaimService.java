package com.example.insurance_project.service;

import com.example.insurance_project.entity.Claim;
import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.repository.ClaimRepository;
import com.example.insurance_project.repository.InsurancePolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    public static final Logger log = LoggerFactory.getLogger(ClaimService.class);

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    public Claim saveNewClaim(Claim claim){
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        claim.setClaimDate(today.format(dateTimeFormatter));
         claimRepository.save(claim);
         log.info("new claim saved : {}   ",claim);
         String claimNumber = "CLM"+(1000+claim.getClaimId());
         claim.setClaimNumber(claimNumber);
        claimRepository.save(claim);
        return claim;
    }

    public Claim getClaimByClaimId(Long claimId){
        Claim claim = claimRepository.findById(claimId).orElseThrow(() -> new EntityNotFoundException("Claim Not Found : "+claimId));

        log.info("claim found by claimId  : {} ", claim);
        return claim;
    }

    public Claim deleteClaimByClaimId(Long claimId){
        Optional<Claim> optionalClaim = claimRepository.findById(claimId);
        if(optionalClaim.isPresent()){
            claimRepository.deleteById(claimId);
            log.info("claim deleted by claim id : {} ", claimId);
            return optionalClaim.get();
        }
        return null;
    }

    public Claim updateExistingClaim(Long claimId, Claim updatedClaim){
        Claim exisitingClaim = claimRepository.findById(claimId).orElseThrow(() -> new EntityNotFoundException("Claim Not Found : "+claimId));

        exisitingClaim.setClaimAmount(updatedClaim.getClaimAmount());
        exisitingClaim.setClaimDate(updatedClaim.getClaimDate());
        exisitingClaim.setClaimDescription(updatedClaim.getClaimDescription());
        exisitingClaim.setClaimStatus(updatedClaim.getClaimStatus());
        exisitingClaim.setClient(updatedClaim.getClient());
        claimRepository.save(exisitingClaim);
        log.info("claim updated : {} ", exisitingClaim);
        return exisitingClaim;
    }



    public List<Claim> displayAllClaims(){

        List<Claim> allClaims = claimRepository.findAll();

        log.info("all claims from db : {} ", allClaims);

        return allClaims;
    }


}
