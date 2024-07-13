package com.example.insurance_project.controller;

import com.example.insurance_project.entity.Client;
import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.response.ApiResponse;
import com.example.insurance_project.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/policy")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @Autowired
    ApiResponse<InsurancePolicy> insurancePolicyApiResponse;

    @GetMapping("/getInsurancePolicyId/{insurancePolicyId}")
    public ApiResponse<InsurancePolicy> getInsurancePolicyByInsurancePolicyId(@PathVariable Long insurancePolicyId) {
        InsurancePolicy insurancePolicy = insurancePolicyService.getInsurancePolicyByInsurancePolicyId(insurancePolicyId);

        if (Objects.isNull(insurancePolicy)) {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            insurancePolicyApiResponse.setMessage("InsurancePolicyNot Found With ClaimId : {} " + insurancePolicyId);
            insurancePolicyApiResponse.setData(null);
        } else {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.FOUND.value());
            insurancePolicyApiResponse.setMessage("InsurancePolicyFound Successfully With insurancePolicyId : {}" + insurancePolicyId);
            insurancePolicyApiResponse.setData(insurancePolicy);
        }
        return insurancePolicyApiResponse;
    }

    @PostMapping("/saveNewInsurancePolicy")
    public ApiResponse<InsurancePolicy> saveNewInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
        InsurancePolicy savedInsurancePolicy = insurancePolicyService.saveInsurancePolicy(insurancePolicy);

        if (Objects.isNull(savedInsurancePolicy)) {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            insurancePolicyApiResponse.setMessage("Failed To Save New InsurancePolicy  : {} " + null);
            insurancePolicyApiResponse.setData(null);
        } else {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.FOUND.value());
            insurancePolicyApiResponse.setMessage("New InsurancePolicy Saved Successfully : {}" + savedInsurancePolicy);
            insurancePolicyApiResponse.setData(savedInsurancePolicy);
        }
        return insurancePolicyApiResponse;
    }


    @PutMapping("/updateClient/{insurancePolicyId}")
    public ApiResponse<InsurancePolicy> updateInsurancePolicy(@PathVariable Long insurancePolicyId, @RequestBody InsurancePolicy updatedInsurancePolicy) {
        InsurancePolicy updateInsurancePolicy = insurancePolicyService.updateInsurancePolicy(insurancePolicyId, updatedInsurancePolicy);

        if (Objects.isNull(updateInsurancePolicy)) {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            insurancePolicyApiResponse.setMessage("Failed To Update InsurancePolicy  : {} " + insurancePolicyId);
            insurancePolicyApiResponse.setData(null);
        } else {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.CREATED.value());
            insurancePolicyApiResponse.setMessage("Updated InsurancePolicy Successfully : {}" + insurancePolicyId);
            insurancePolicyApiResponse.setData(updateInsurancePolicy);
        }
        return insurancePolicyApiResponse;
    }

    @DeleteMapping("deleteInsurancePolicyId/{insurancePolicyId}")
    public ApiResponse<InsurancePolicy> deleteInsurancePolicyId(@PathVariable Long insurancePolicyId) {

        try {
            InsurancePolicy insurancePolicy = insurancePolicyService.deleteInsurancePolicyById(insurancePolicyId);
            insurancePolicyApiResponse.setStatusCode(HttpStatus.OK.value());
            insurancePolicyApiResponse.setMessage("Claim Deleted Successfully With ClaimId: {}" + insurancePolicyId);
            insurancePolicyApiResponse.setData(insurancePolicy);
        } catch (Exception e) {
            insurancePolicyApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            insurancePolicyApiResponse.setMessage("Failed Delete With ClaimId: {}" + insurancePolicyId);
            insurancePolicyApiResponse.setData(null);
        }

        return insurancePolicyApiResponse;
    }

    @GetMapping("getAllClients")
    public ResponseEntity<List<InsurancePolicy>> getAllClaims() {
        try {
            List<InsurancePolicy> insurancePolicies = insurancePolicyService.displayInsurancePolicies();
            return new ResponseEntity<>(insurancePolicies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
