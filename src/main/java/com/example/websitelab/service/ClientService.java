package com.example.websitelab.service;

import com.example.websitelab.dto.ClientDto;
import com.example.websitelab.entity.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(ClientDto clientDto);

    List<Client> getAllClients();

    Client deleteClient(Long clientId);

    Client updateClient(Long clientId, ClientDto clientDto);
}
