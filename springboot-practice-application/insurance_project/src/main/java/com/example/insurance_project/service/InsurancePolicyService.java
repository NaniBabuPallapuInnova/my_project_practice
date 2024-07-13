package com.example.insurance_project.service;

import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.repository.InsurancePolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyService {

    public static final Logger log = LoggerFactory.getLogger(InsurancePolicyService.class);


    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy){

        insurancePolicyRepository.save(insurancePolicy);
        log.info("New InsurancePolicy Saved : {}   ",insurancePolicy);

        String insurancePolicyNumber = "POL"+(1000+insurancePolicy.getInsurancePolicyId());
        insurancePolicy.setInsurancePolicyNumber(insurancePolicyNumber);
        return insurancePolicy;
    }

    public InsurancePolicy getInsurancePolicyByInsurancePolicyId(Long insurancePolicyId){
        InsurancePolicy insurancePolicy =  insurancePolicyRepository.findById(insurancePolicyId).orElseThrow(() -> new EntityNotFoundException("InsurancePolicy Not Found "+insurancePolicyId));
        log.info("InsurancePolicy Found : {} ",insurancePolicy);
        return insurancePolicy;
    }

    public InsurancePolicy deleteInsurancePolicyById(Long insurancePolicyId){
        Optional<InsurancePolicy> insurancePolicy =  insurancePolicyRepository.findById(insurancePolicyId);
        if(insurancePolicy.isPresent()){
            insurancePolicyRepository.deleteById(insurancePolicyId);
            log.info("InsurancePolicy Deleted : {} ",insurancePolicy);
            return insurancePolicy.get();
        }
        return null;
    }

    public InsurancePolicy updateInsurancePolicy(Long insurancePolicyId, InsurancePolicy updatedInsurancePolicy){
        InsurancePolicy existingInsurancePolicy =  insurancePolicyRepository.findById(insurancePolicyId).orElseThrow(() -> new EntityNotFoundException("InsurancePolicy Not Found "+insurancePolicyId));

        existingInsurancePolicy.setInsurancePolicyType(updatedInsurancePolicy.getInsurancePolicyType());
        existingInsurancePolicy.setInsurancePolicyStartDate(updatedInsurancePolicy.getInsurancePolicyStartDate());
        existingInsurancePolicy.setInsurancePolicyPremium(updatedInsurancePolicy.getInsurancePolicyPremium());
        existingInsurancePolicy.setInsurancePolicyEndDate(updatedInsurancePolicy.getInsurancePolicyEndDate());
        existingInsurancePolicy.setInsurancePolicyCoverageAmount(updatedInsurancePolicy.getInsurancePolicyCoverageAmount());

        insurancePolicyRepository.save(existingInsurancePolicy);

        return existingInsurancePolicy;

    }
    public List<InsurancePolicy> displayInsurancePolicies(){
        return insurancePolicyRepository.findAll();
    }

}
