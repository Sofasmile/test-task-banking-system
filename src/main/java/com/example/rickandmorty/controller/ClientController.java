package com.example.rickandmorty.controller;

import com.example.rickandmorty.dto.AccountRequestDto;
import com.example.rickandmorty.dto.ClientRequestDto;
import com.example.rickandmorty.dto.ClientResponseDto;
import com.example.rickandmorty.entity.Account;
import com.example.rickandmorty.entity.Client;
import com.example.rickandmorty.mapper.AccountMapper;
import com.example.rickandmorty.mapper.ClientMapper;
import com.example.rickandmorty.service.AccountService;
import com.example.rickandmorty.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper,
                            AccountMapper accountMapper, AccountService accountService) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
        this.accountMapper = accountMapper;
        this.accountService = accountService;
    }

    // TODO remove
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping
    public ClientResponseDto create(@RequestBody ClientRequestDto clientRequestDto) {
        Client client = clientMapper.toEntity(clientRequestDto);
        List<AccountRequestDto> accountsDtos = clientRequestDto.getAccounts();

        Client savedClient = clientService.save(client);
        List<Account> accounts = accountsDtos.stream()
                .map(a -> accountMapper.toEntity(a, savedClient))
                .collect(Collectors.toList());
        List<Account> savedAccounts = accountService.saveAll(accounts);
        return clientMapper.toDto(savedClient, savedAccounts);
    }
}
