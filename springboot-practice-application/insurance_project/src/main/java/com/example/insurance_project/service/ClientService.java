package com.example.insurance_project.service;

import java.util.List;

import com.example.insurance_project.dao.ClientDao;
import com.example.insurance_project.dao.InsurancePolicyDao;
import com.example.insurance_project.entity.Client;
import com.example.insurance_project.entity.InsurancePolicy;
import com.example.insurance_project.response.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ResponseStructure<Client> responseStructure;

    @Autowired
    private InsurancePolicyDao insurancePolicyDao;

    @Autowired
    private ResponseStructure<List<Client>> responseStructure2;

    // insert Client(we need here policy id to connect with client table)----------------------------------
    public ResponseStructure<Client> insertClient(Client client, int policyId){
        InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(policyId);

        if(insurancePolicy != null) {
            client.setInsurancePolicy(insurancePolicy);
            clientDao.insertClient(client);

            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("data inserted successfully");
            responseStructure.setData(client);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMsg("data is not saved ");
            responseStructure.setData(null);
            return responseStructure;
        }
    }

    // getByClientId---------------------------------------------------------------------------------------
    public ResponseStructure<Client> getClientById(int clientId) {
        Client client = clientDao.getClientById(clientId);

        if(client != null) {
            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("Data fetch succeffully");
            responseStructure.setData(client);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("Given id is not present in database");
            responseStructure.setData(null);
            return responseStructure;
        }

    }

    // update Client--------------------------------------------------------------------------------------
    public ResponseStructure<Client> updateClient(Client client, int clientId) {
        Client client2 = clientDao.getClientById(clientId);

        if(client2 != null) {
            client2.setClientName(client.getClientName());
            client2.setClientAddress(client.getClientAddress());
            client2.setClientContactInformation(client.getClientContactInformation());
            client2.setClientDateOfBirth(client.getClientDateOfBirth());
            clientDao.updateClient(client2);

            responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure.setMsg("data updated successfully");
            responseStructure.setData(client2);
            return responseStructure;

        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure.setMsg("data is not updated because given id is not present ");
            responseStructure.setData(null);
            return responseStructure;
        }
    }

    //delete Client-----------------------------------------------------------------------------------------
    public ResponseStructure<Client> deleteClient(Client client,int clientId) {
        Client client1 = clientDao.deleteClient(client, clientId);

        if(client1 != null) {

            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMsg("Data Deleted Successfully");
            responseStructure.setData(client1);
            return responseStructure;
        }else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMsg("Given id is not present in database");
            responseStructure.setData(null);
            return responseStructure;
        }
    }

    //display Client----------------------------------------------------------------------------------------
    public ResponseStructure<List<Client>> displayAllCLient(){
        List<Client> clients = clientDao.displayAllCLient();

        if(clients != null) {
            responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
            responseStructure2.setMsg("Clients-details");
            responseStructure2.setData(clients);
            return responseStructure2;
        }else {
            responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            responseStructure2.setMsg("clients-details not found");
            responseStructure2.setData(null);
            return responseStructure2;
        }
    }

}