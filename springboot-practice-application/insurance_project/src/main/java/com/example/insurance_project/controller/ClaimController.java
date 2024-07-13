package com.example.insurance_project.controller;

import com.example.insurance_project.entity.Claim;
import com.example.insurance_project.response.ApiResponse;
import com.example.insurance_project.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @Autowired
    ApiResponse<Claim> claimApiResponse;

    @GetMapping("/getClaimById/{claimId}")
    public ApiResponse<Claim> getClaimById(@PathVariable Long claimId) {
        Claim claim = claimService.getClaimByClaimId(claimId);

        if (Objects.isNull(claim)) {
            claimApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            claimApiResponse.setMessage("Claim Not Found With ClaimId : {} " + claimId);
            claimApiResponse.setData(null);
        } else {
            claimApiResponse.setStatusCode(HttpStatus.FOUND.value());
            claimApiResponse.setMessage("Claim Found Successfully With ClaimId : {}" + claimId);
            claimApiResponse.setData(claim);
        }
        return claimApiResponse;
    }

    @PostMapping("/saveNewClaim")
    public ApiResponse<Claim> saveNewClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.saveNewClaim(claim);

        if (Objects.isNull(savedClaim)) {
            claimApiResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            claimApiResponse.setMessage("Failed To Save New Claim  : {} " + savedClaim);
            claimApiResponse.setData(null);
        } else {
            claimApiResponse.setStatusCode(HttpStatus.FOUND.value());
            claimApiResponse.setMessage("New Claim Saved Successfully : {}" + savedClaim);
            claimApiResponse.setData(savedClaim);
        }
        return claimApiResponse;
    }

    @PutMapping("/updateClaim/{claimId}")
    public ApiResponse<Claim> updateClaim(@PathVariable Long claimId, @RequestBody Claim claim) {
        Claim updatedClaimDetails = claimService.updateExistingClaim(claimId, claim);

        if (Objects.isNull(updatedClaimDetails)) {
            claimApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            claimApiResponse.setMessage("Failed To Update Claim  : {} " + claimId);
            claimApiResponse.setData(null);
        } else {
            claimApiResponse.setStatusCode(HttpStatus.CREATED.value());
            claimApiResponse.setMessage("Updated Successfully : {}" + claimId);
            claimApiResponse.setData(updatedClaimDetails);
        }
        return claimApiResponse;
    }

    @DeleteMapping("/deleteClaimId/{claimId}")
    public ApiResponse<Claim> deleteClaimByClaimId(@PathVariable Long claimId) {
        try {
            Claim claim = claimService.deleteClaimByClaimId(claimId);
            claimApiResponse.setStatusCode(HttpStatus.OK.value());
            claimApiResponse.setMessage("Claim Deleted Successfully With ClaimId: {}" + claimId);
            claimApiResponse.setData(claim);
        } catch (Exception e) {
            claimApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            claimApiResponse.setMessage("Failed Delete With ClaimId: {}" + claimId);
            claimApiResponse.setData(null);
        }

        return claimApiResponse;
    }

    @GetMapping("/getAllClaims")
    public ResponseEntity<List<Claim>> getAllClaims() {
        try {
            List<Claim> claimList = claimService.displayAllClaims();
            return new ResponseEntity<>(claimList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
