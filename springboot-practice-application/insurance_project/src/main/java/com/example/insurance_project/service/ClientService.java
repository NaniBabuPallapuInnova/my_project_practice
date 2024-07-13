package com.example.insurance_project.service;

import com.example.insurance_project.entity.Client;
import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.repository.ClientRepository;
import com.example.insurance_project.repository.InsurancePolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    public static final Logger log = LoggerFactory.getLogger(ClaimService.class);
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    InsurancePolicyService insurancePolicyService;

    public Client saveNewClient(Client client) {

        if(client.getInsurancePolicy() != null){
            InsurancePolicy insurancePolicy = insurancePolicyService.saveInsurancePolicy(client.getInsurancePolicy());
            client.setInsurancePolicy(insurancePolicy);
        }
        Client savedClient = clientRepository.save(client);
        log.info("saved new client successfully : {}", savedClient);
        return savedClient;
    }

    public Client getClientByClientId(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if(optionalClient.isPresent()){
            log.info("fetched client successfully : {}", optionalClient.get().getClientId());
            return optionalClient.get();
        }
        return null;
    }

    public Client deleteClientByClientId(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);

        if (optionalClient.isPresent()) {
            clientRepository.deleteById(clientId);
            log.info("client deleted successfully : {} ", clientId);
            return optionalClient.get();
        }

        return null;

    }

    public Client updateExistingClient(Long clientId, Client updatedClient) {
        Client existingClient = clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client Not Found " + clientId));

        existingClient.setClientName(updatedClient.getClientName());
        existingClient.setClientDateOfBirth(updatedClient.getClientDateOfBirth());
        existingClient.setClientAddress(updatedClient.getClientAddress());
        existingClient.setClientContactNumber(updatedClient.getClientContactNumber());

        InsurancePolicy updatedInsurancePolicy = updatedClient.getInsurancePolicy();

        InsurancePolicy existingInsurancePolicy = insurancePolicyRepository.findById(updatedInsurancePolicy.getInsurancePolicyId()).orElseThrow(() -> new EntityNotFoundException("Insurance Policy Not Found " + updatedInsurancePolicy.getInsurancePolicyId()));

        existingInsurancePolicy.setInsurancePolicyType(updatedInsurancePolicy.getInsurancePolicyType());
        existingInsurancePolicy.setInsurancePolicyStartDate(updatedInsurancePolicy.getInsurancePolicyStartDate());
        existingInsurancePolicy.setInsurancePolicyPremium(updatedInsurancePolicy.getInsurancePolicyPremium());
        existingInsurancePolicy.setInsurancePolicyEndDate(updatedInsurancePolicy.getInsurancePolicyEndDate());
        existingInsurancePolicy.setInsurancePolicyCoverageAmount(updatedInsurancePolicy.getInsurancePolicyCoverageAmount());

        insurancePolicyRepository.save(existingInsurancePolicy);


        existingClient.setInsurancePolicy(existingInsurancePolicy);
        clientRepository.save(existingClient);

        log.info("updated client information successfully : {} ", existingClient);
        return existingClient;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

}
