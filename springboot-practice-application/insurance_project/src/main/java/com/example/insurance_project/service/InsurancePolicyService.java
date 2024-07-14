package com.example.insurance_project.service;


import com.example.insurance_project.dao.InsurancePolicyDao;
import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.response.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyDao insurancePolicyDao;

    @Autowired
    private ResponseStructure<InsurancePolicy> responseStructure;

    @Autowired
    private ResponseStructure<List<InsurancePolicy>> responseStructure2;

    // insert insurancePolicy-----------------------------------------------------------
    public ResponseStructure<InsurancePolicy> insertInsurancePolicy(InsurancePolicy insurancePolicy) {
        InsurancePolicy insurancePolicy2 = insurancePolicyDao.insertInsurancePolicy(insurancePolicy);

        if(insurancePolicy2 != null) {
            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("data inserted successfully");
            responseStructure.setData(insurancePolicy2);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("data not inserted please check again your code");
            responseStructure.setData(null);
            return responseStructure;
        }
    }

    // getByInsurancePolicyId------------------------------------------------------------
    public ResponseStructure<InsurancePolicy> getByInsurancePolicyId(int insurancePolicyId) {
        InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(insurancePolicyId);

        if(insurancePolicy != null) {
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMsg("data fetch successfull, data is available");
            responseStructure.setData(insurancePolicy);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMsg("please check your id which you are given");
            responseStructure.setData(null);
            return responseStructure;
        }
    }

    // update Insurance Policy------------------------------------------------------------
    public ResponseStructure<InsurancePolicy> updateInsurancePolicy(InsurancePolicy insurancePolicy, int insurancePolicyId) {
        InsurancePolicy insurancePolicy2 = insurancePolicyDao.updateInsurancePolicy(insurancePolicy, insurancePolicyId);

        if(insurancePolicy2 != null) {
            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("Data is updated suceesfully because id is present");
            responseStructure.setData(insurancePolicy2);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMsg("given id is not present in database");
            responseStructure.setData(null);
            return responseStructure;
        }
    }

    // delete Insurance Policy---------------------------------------------------------------
    public ResponseStructure<InsurancePolicy> deleteInsurancePolicy(InsurancePolicy insurancePolicy,int policyId){
        InsurancePolicy insurancePolicy2 = insurancePolicyDao.deleteInsurancePolicy(insurancePolicy, policyId);

        if(insurancePolicy !=null) {
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMsg("Data Deleted Successfully");
            responseStructure.setData(insurancePolicy2);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMsg("data is not deleted because Id is not present in database");
            responseStructure.setData(null);
            return responseStructure;
        }

    }

    //display InsuarncePolicy-------------------------------------------------------------------
    public ResponseStructure<List<InsurancePolicy>> displayAllPolicy(){
        List<InsurancePolicy> insurancePolicies = insurancePolicyDao.displayAllPolicy();

        if(insurancePolicies != null) {
            responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure2.setMsg("Policy-details");
            responseStructure2.setData(insurancePolicies);
            return responseStructure2;
        }else {
            responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure2.setMsg("Policy-details not found");
            responseStructure2.setData(null);
            return responseStructure2;
        }

    }
}