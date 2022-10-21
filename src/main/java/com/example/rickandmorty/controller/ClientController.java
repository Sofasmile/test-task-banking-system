package com.example.rickandmorty.controller;

import com.example.rickandmorty.dto.ClientRequestDto;
import com.example.rickandmorty.dto.ClientResponseDto;
import com.example.rickandmorty.entity.Client;
import com.example.rickandmorty.mapper.ClientMapper;
import com.example.rickandmorty.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    // TODO remove
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping
    public ClientResponseDto create(@RequestBody ClientRequestDto clientRequestDto) {
        Client client = clientMapper.toEntity(clientRequestDto);
        Client savedClient = clientService.save(client);
        return clientMapper.toDto(savedClient);
    }
}
