package com.example.insurance_project.controller;

import java.util.List;

import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.response.ResponseStructure;
import com.example.insurance_project.service.InsurancePolicyService;
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
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService insurancePolicyService;

    // insert insurancePolicy------------------------------------------------------------------
    @PostMapping("/saveInsurancePolicy")
    public ResponseStructure<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
        return insurancePolicyService.insertInsurancePolicy(insurancePolicy);
    }

    // getByInsurancePolicyId-------------------------------------------------------------------------------
    @GetMapping("/getByInsurancePolicyId/{insurancePolicyId}")
    public ResponseStructure<InsurancePolicy> getByInsurancePolicyId(@PathVariable int insurancePolicyId) {
        return insurancePolicyService.getByInsurancePolicyId(insurancePolicyId);
    }

    // update Insurance Policy------------------------------------------------------------------------------------
    @PutMapping("/updateInsurancePolicy/{insurancePolicyId}")
    public ResponseStructure<InsurancePolicy> updateInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy,@PathVariable int insurancePolicyId) {
        return insurancePolicyService.updateInsurancePolicy(insurancePolicy, insurancePolicyId);
    }

    // delete Insurance Policy-------------------------------------------------------------------------------------
    @DeleteMapping("/deleteInsurancePolicy/{policyId}")
    public ResponseStructure<InsurancePolicy> deleteInsurancePolicy(InsurancePolicy insurancePolicy, @PathVariable int policyId){
        return insurancePolicyService.deleteInsurancePolicy(insurancePolicy, policyId);
    }

    //display InsuarncePolicy------------------------------------------------------------------------------------
    @GetMapping("/displayAllPolicy")
    public ResponseStructure<List<InsurancePolicy>> displayAllPolicy(){
        return insurancePolicyService.displayAllPolicy();
    }
}