package com.example.insurance_project.dao;


import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InsurancePolicyDao {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    // insert insurancePolicy-----------------------------------------------------------
    public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
        InsurancePolicy savedInsurancePolicy = insurancePolicyRepository.save(insurancePolicy);
        String insurancePolicyNumber = "POL" + (100 + savedInsurancePolicy.getInsurancePolicyId());
        savedInsurancePolicy.setInsurancePolicyNumber(insurancePolicyNumber);
        return insurancePolicyRepository.save(savedInsurancePolicy);
    }

    // getByInsurancePolicyId------------------------------------------------------------
    public InsurancePolicy getByInsurancePolicyId(int insurancePolicyId) {
        Optional<InsurancePolicy> optional = insurancePolicyRepository.findById(insurancePolicyId);

        if (optional.isPresent()) {
            InsurancePolicy insurancePolicy = optional.get();
            return insurancePolicy;
        } else {
            return null;
        }
    }

    // update Insurance Policy------------------------------------------------------------
    public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy, int insurancePolicyId) {
        Optional<InsurancePolicy> optional = insurancePolicyRepository.findById(insurancePolicyId);

        InsurancePolicy insurancePolicy2 = optional.get();
        if ((insurancePolicy.getInsurancePolicyNumber() != null) && (insurancePolicy.getInsurancePolicyType() != null) &&
                (insurancePolicy.getInsurancePolicyCoverageAmount() != 0) && (insurancePolicy.getInsurancePolicyPremium() != null) &&
                (insurancePolicy.getInsurancePolicyStartDate() != null) && (insurancePolicy.getInsurancePolicyEndDate() != null)) {


            insurancePolicy2.setInsurancePolicyNumber(insurancePolicy.getInsurancePolicyNumber());
            insurancePolicy2.setInsurancePolicyType(insurancePolicy.getInsurancePolicyType());
            insurancePolicy2.setInsurancePolicyCoverageAmount(insurancePolicy.getInsurancePolicyCoverageAmount());
            insurancePolicy2.setInsurancePolicyPremium(insurancePolicy.getInsurancePolicyPremium());
            insurancePolicy2.setInsurancePolicyStartDate(insurancePolicy.getInsurancePolicyStartDate());
            insurancePolicy2.setInsurancePolicyEndDate(insurancePolicy.getInsurancePolicyEndDate());

            insurancePolicyRepository.save(insurancePolicy2);
            return insurancePolicy;
        } else {
            return null;
        }

    }

    // delete Insurance Policy---------------------------------------------------------------
    public InsurancePolicy deleteInsurancePolicy(InsurancePolicy insurancePolicy, int policyId) {
        Optional<InsurancePolicy> optional = insurancePolicyRepository.findById(policyId);

        if (optional.isPresent()) {
            insurancePolicyRepository.delete(optional.get());
            return insurancePolicy;
        } else {
            return null;
        }
    }

    //display InsuarncePolicy-------------------------------------------------------------------
    public List<InsurancePolicy> displayAllPolicy() {
        return insurancePolicyRepository.findAll();
    }

}
