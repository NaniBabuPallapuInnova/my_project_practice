package com.example.insurance_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private String claimNumber;

    private String claimDescription;

    private String claimDate;

    private String claimStatus;

    private String claimAmount;


    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;



    public Claim() {
    }

    public Claim(Long claimId, String claimNumber, String claimDescription, String claimDate, String claimStatus, String claimAmount, Client client) {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.claimDescription = claimDescription;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.claimAmount = claimAmount;
        this.client = client;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(String claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", claimNumber='" + claimNumber + '\'' +
                ", claimDescription='" + claimDescription + '\'' +
                ", claimDate='" + claimDate + '\'' +
                ", claimStatus='" + claimStatus + '\'' +
                ", claimAmount='" + claimAmount + '\'' +
                ", client=" + client +
                '}';
    }
}
