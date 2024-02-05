package com.example.websitelab.service.Impl;

import com.example.websitelab.dto.ClientDto;
import com.example.websitelab.entity.Client;
import com.example.websitelab.repository.ClientRepository;
import com.example.websitelab.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Client saveClient(ClientDto clientDto) {

        Client client = new Client();
        client.setFullName(clientDto.getFullName());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setCompanyName(clientDto.getCompanyName());
        client.setTaskDescription(clientDto.getTaskDescription());

        return clientRepository.save(client);

    }

    @Override
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @Override
    public Client deleteClient(Long clientId) {
        if (Objects.isNull(clientId)) {
            System.out.println("Null");
        }
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.map(client -> {
            clientRepository.delete(client);
            return client;
        }).orElse(null);
    }

    @Override
    public Client updateClient(Long clientId, ClientDto updatedClientDto) {
        if (Objects.isNull(clientId) || Objects.isNull(updatedClientDto)) {
            System.out.println("Null");
        }

        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.map(client -> {
            client.setFullName(updatedClientDto.getFullName());
            client.setEmail(updatedClientDto.getEmail());
            client.setPhoneNumber(updatedClientDto.getPhoneNumber());
            client.setCompanyName(updatedClientDto.getCompanyName());
            client.setTaskDescription(updatedClientDto.getTaskDescription());
            return clientRepository.save(client);
        }).orElse(null);
    }
}