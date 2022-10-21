package com.example.rickandmorty.service;

import com.example.rickandmorty.entity.Client;
import com.example.rickandmorty.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
