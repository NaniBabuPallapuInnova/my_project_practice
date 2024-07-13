package com.example.insurance_project.controller;

import com.example.insurance_project.entity.Client;
import com.example.insurance_project.response.ApiResponse;
import com.example.insurance_project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ApiResponse<Client> clientApiResponse;

    @GetMapping("/getClientId/{clientId}")
    public ApiResponse<Client> getClaimById(@PathVariable Long clientId) {
        Client client = clientService.getClientByClientId(clientId);

        if (Objects.isNull(client)) {
            clientApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            clientApiResponse.setMessage("Client Not Found With ClaimId : {} " + clientId);
            clientApiResponse.setData(null);
        } else {
            clientApiResponse.setStatusCode(HttpStatus.FOUND.value());
            clientApiResponse.setMessage("Client Found Successfully With ClientId : {}" + clientId);
            clientApiResponse.setData(client);
        }
        return clientApiResponse;
    }

    @PostMapping("/saveNewClient")
    public ApiResponse<Client> saveNewClient(@RequestBody Client client) {
        Client savedNewClient = clientService.saveNewClient(client);

        if (Objects.isNull(savedNewClient)) {
            clientApiResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            clientApiResponse.setMessage("Failed To Save New Claim  : {} " + null);
            clientApiResponse.setData(null);
        } else {
            clientApiResponse.setStatusCode(HttpStatus.FOUND.value());
            clientApiResponse.setMessage("New Claim Saved Successfully : {}" + savedNewClient);
            clientApiResponse.setData(savedNewClient);
        }
        return clientApiResponse;
    }

    @PutMapping("/updateClient/{clientId}")
    public ApiResponse<Client> updateClaim(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        Client updatedClientDetails = clientService.updateExistingClient(clientId, updatedClient);

        if (Objects.isNull(updatedClientDetails)) {
            clientApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            clientApiResponse.setMessage("Failed To Update Claim  : {} " + clientId);
            clientApiResponse.setData(null);
        } else {
            clientApiResponse.setStatusCode(HttpStatus.CREATED.value());
            clientApiResponse.setMessage("Updated Successfully : {}" + clientId);
            clientApiResponse.setData(updatedClientDetails);
        }
        return clientApiResponse;
    }

    @DeleteMapping("/deleteClientId/{clientId}")
    public ApiResponse<Client> deleteClientId(@PathVariable Long clientId) {

        try {
            Client client = clientService.deleteClientByClientId(clientId);
            clientApiResponse.setStatusCode(HttpStatus.OK.value());
            clientApiResponse.setMessage("Claim Deleted Successfully With ClaimId: {}" + client);
            clientApiResponse.setData(client);
        } catch (Exception e) {
            clientApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            clientApiResponse.setMessage("Failed Delete With ClaimId: {}" + clientId);
            clientApiResponse.setData(null);
        }

        return clientApiResponse;
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClaims() {
        try {
            List<Client> clientList = clientService.getAllClients();
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
