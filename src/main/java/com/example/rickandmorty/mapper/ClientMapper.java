package com.example.rickandmorty.mapper;

import com.example.rickandmorty.dto.AccountResponseDto;
import com.example.rickandmorty.dto.ClientRequestDto;
import com.example.rickandmorty.dto.ClientResponseDto;
import com.example.rickandmorty.entity.Account;
import com.example.rickandmorty.entity.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    private final AccountMapper accountMapper;

    public ClientMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Client toEntity(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client.setFirstName(clientRequestDto.getFirstName());
        client.setLastName(clientRequestDto.getLastName());
        return client;
    }

    public ClientResponseDto toDto(Client client) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setFirstName(client.getFirstName());
        clientResponseDto.setLastName(client.getLastName());
        clientResponseDto.setId(client.getId());
        return clientResponseDto;
    }

    public ClientResponseDto toDto(Client client, List<Account> accounts) {
        List<AccountResponseDto> accountsDto = accounts.stream()
                .map(a -> accountMapper.toDto(a))
                .collect(Collectors.toList());

        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setFirstName(client.getFirstName());
        clientResponseDto.setLastName(client.getLastName());
        clientResponseDto.setId(client.getId());
        clientResponseDto.setAccounts(accountsDto);
        return clientResponseDto;
    }
}
