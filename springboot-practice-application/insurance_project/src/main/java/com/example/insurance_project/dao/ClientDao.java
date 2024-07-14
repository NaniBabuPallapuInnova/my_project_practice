package com.example.insurance_project.dao;


import com.example.insurance_project.entity.Client;
import com.example.insurance_project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientDao {

    @Autowired
    private ClientRepository clientRepository;

    // insert Client(we need here policy id to connect with client table)----------------------------------
    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }

    // getByClientId---------------------------------------------------------------------------------------
    public Client getClientById(int clientId) {
        Optional<Client> optional = clientRepository.findById(clientId);

        if(optional.isPresent()) {
            return optional.get();
        }else {
            return null;
        }
    }

    // update Client--------------------------------------------------------------------------------------
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    //delete Client-----------------------------------------------------------------------------------------
    public Client deleteClient(Client client, int clientId) {
        Optional<Client> optional = clientRepository.findById(clientId);

        if(optional.isPresent()) {
            clientRepository.delete(optional.get());
            return client;
        }else {
            return null;
        }
    }

    //display Client----------------------------------------------------------------------------------------
    public List<Client> displayAllCLient(){
        return clientRepository.findAll();
    }
}
