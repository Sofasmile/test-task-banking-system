package com.example.rickandmorty.service;

import com.example.rickandmorty.entity.Client;
import com.example.rickandmorty.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AccountService accountService;

    public ClientServiceImpl(ClientRepository clientRepository,
                             AccountService accountService) {
        this.clientRepository = clientRepository;
        this.accountService = accountService;
    }

    @Transactional
    public Client save(Client client) {
        accountService.saveAll(client.getAccounts());
        return clientRepository.save(client);
    }
}
