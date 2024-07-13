package com.example.insurance_project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "insurance_policy")
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long insurancePolicyId;

    @Column(name = "policy_number")
    private String insurancePolicyNumber;

    @Column(name = "policy_type")
    private String insurancePolicyType;

    @Column(name = "policy_coverage_amount")
    private Long insurancePolicyCoverageAmount;

    @Column(name = "policy_premium")
    private String insurancePolicyPremium;

    @Column(name = "policy_start_date")
    private String insurancePolicyStartDate;

    @Column(name = "policy_end_date")
    private String insurancePolicyEndDate;



    public InsurancePolicy() {

    }

    public InsurancePolicy(Long insurancePolicyId, String insurancePolicyNumber, String insurancePolicyType, Long insurancePolicyCoverageAmount, String insurancePolicyPremium, String insurancePolicyStartDate, String insurancePolicyEndDate) {
        this.insurancePolicyId = insurancePolicyId;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insurancePolicyType = insurancePolicyType;
        this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
        this.insurancePolicyPremium = insurancePolicyPremium;
        this.insurancePolicyStartDate = insurancePolicyStartDate;
        this.insurancePolicyEndDate = insurancePolicyEndDate;
    }

    public Long getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(Long insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getInsurancePolicyType() {
        return insurancePolicyType;
    }

    public void setInsurancePolicyType(String insurancePolicyType) {
        this.insurancePolicyType = insurancePolicyType;
    }

    public Long getInsurancePolicyCoverageAmount() {
        return insurancePolicyCoverageAmount;
    }

    public void setInsurancePolicyCoverageAmount(Long insurancePolicyCoverageAmount) {
        this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
    }

    public String getInsurancePolicyPremium() {
        return insurancePolicyPremium;
    }

    public void setInsurancePolicyPremium(String insurancePolicyPremium) {
        this.insurancePolicyPremium = insurancePolicyPremium;
    }

    public String getInsurancePolicyStartDate() {
        return insurancePolicyStartDate;
    }

    public void setInsurancePolicyStartDate(String insurancePolicyStartDate) {
        this.insurancePolicyStartDate = insurancePolicyStartDate;
    }

    public String getInsurancePolicyEndDate() {
        return insurancePolicyEndDate;
    }

    public void setInsurancePolicyEndDate(String insurancePolicyEndDate) {
        this.insurancePolicyEndDate = insurancePolicyEndDate;
    }


    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "insurancePolicyId=" + insurancePolicyId +
                ", insurancePolicyNumber='" + insurancePolicyNumber + '\'' +
                ", insurancePolicyType='" + insurancePolicyType + '\'' +
                ", insurancePolicyCoverageAmount=" + insurancePolicyCoverageAmount +
                ", insurancePolicyPremium='" + insurancePolicyPremium + '\'' +
                ", insurancePolicyStartDate='" + insurancePolicyStartDate + '\'' +
                ", insurancePolicyEndDate='" + insurancePolicyEndDate + '\'' +
                '}';
    }
}
