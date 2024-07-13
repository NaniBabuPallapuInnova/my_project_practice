package com.example.insurance_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String clientName;

    @Column(name = "client_dob")
    private String clientDateOfBirth;

    private String clientAddress;

    @Column(name = "client_contact_number")
    private Long clientContactNumber;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy insurancePolicy;

    @OneToMany( mappedBy="client",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Claim> claims;

    public Client() {
    }

    public Client(Long clientId, String clientName, String clientDateOfBirth, String clientAddress, Long clientContactNumber, InsurancePolicy insurancePolicy, List<Claim> claims) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientDateOfBirth = clientDateOfBirth;
        this.clientAddress = clientAddress;
        this.clientContactNumber = clientContactNumber;
        this.insurancePolicy = insurancePolicy;
        this.claims = claims;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientDateOfBirth() {
        return clientDateOfBirth;
    }

    public void setClientDateOfBirth(String clientDateOfBirth) {
        this.clientDateOfBirth = clientDateOfBirth;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Long getClientContactNumber() {
        return clientContactNumber;
    }

    public void setClientContactNumber(Long clientContactNumber) {
        this.clientContactNumber = clientContactNumber;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientDateOfBirth='" + clientDateOfBirth + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientContactNumber=" + clientContactNumber +
                ", insurancePolicy=" + insurancePolicy +
                ", claims=" + claims +
                '}';
    }
}
