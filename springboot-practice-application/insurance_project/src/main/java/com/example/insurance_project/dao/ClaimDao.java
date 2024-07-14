package com.example.insurance_project.dao;


import com.example.insurance_project.entity.Claim;
import com.example.insurance_project.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Repository
public class ClaimDao {

    @Autowired
    private ClaimRepository claimRepository;

    //insert Claim------------------------------------------------------------------------------
    public Claim insertClaim(Claim claim) {

        Claim savedClaim = claimRepository.save(claim);
        String claimNumber = "CLM" + (100 + savedClaim.getClaimId());
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        savedClaim.setClaimDate(dateTimeFormatter.format(today));
        savedClaim.setClaimNumber(claimNumber);
        return claimRepository.save(savedClaim);
    }

    // getByClaimId-----------------------------------------------------------------------------
    public Claim getByClaimId(int claimId) {
        Optional<Claim> optional = claimRepository.findById(claimId);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // delete Claim-----------------------------------------------------------------------------
    public Claim deleteClaim(Claim claim, int claimId) {
        Optional<Claim> optional = claimRepository.findById(claimId);

        if (optional.isPresent()) {
            claimRepository.delete(optional.get());
            return claim;
        } else {
            return null;
        }
    }


    // update Claim------------------------------------------------------------------------------
    public Claim updateClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    //displayAllClaim----------------------------------------------------------------------------
    public List<Claim> displayAllClaim() {
        return claimRepository.findAll();
    }
}