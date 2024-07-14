package com.example.insurance_project.controller;

import java.util.List;

import com.example.insurance_project.entity.Claim;
import com.example.insurance_project.response.ResponseStructure;
import com.example.insurance_project.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    //insert Claim---------------------------------------------------------------------
    @PostMapping("/saveClaim/{policyId}")
    public ResponseStructure<Claim> insertClaim(@RequestBody Claim claim, @PathVariable int policyId) {
        return claimService.insertClaim(claim, policyId);
    }

    // getByClaimId-----------------------------------------------------------------------------
    @GetMapping("/getByClaimId/{claimId}")
    public ResponseStructure<Claim> getByClaimId(@PathVariable int claimId) {
        return claimService.getByClaimId(claimId);
    }

    // delete Claim-----------------------------------------------------------------------------
    @DeleteMapping("/deleteClaim/{claimId}")
    public ResponseStructure<Claim> deleteClaim(Claim claim, @PathVariable int claimId) {
        return claimService.deleteClaim(claim, claimId);
    }

    // update Claim------------------------------------------------------------------------------
    @PutMapping("/updateClaim/{claimId}")
    public ResponseStructure<Claim> updateClaim(@RequestBody Claim claim,@PathVariable int claimId) {
        return claimService.updateClaim(claim, claimId);
    }

    //displayAllClaim----------------------------------------------------------------------------
    @GetMapping("/displayAllClaim")
    public ResponseStructure<List<Claim>> displayAllClaim(){
        return claimService.displayAllClaim();
    }
}