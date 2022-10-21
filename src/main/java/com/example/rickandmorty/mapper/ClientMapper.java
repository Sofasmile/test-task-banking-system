package com.example.rickandmorty.mapper;

import com.example.rickandmorty.dto.AccountResponseDto;
import com.example.rickandmorty.dto.ClientRequestDto;
import com.example.rickandmorty.dto.ClientResponseDto;
import com.example.rickandmorty.entity.Account;
import com.example.rickandmorty.entity.Client;
import org.springframework.stereotype.Component;
import java.util.List;

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
        List<Account> accounts = accountMapper.toEntity(clientRequestDto.getAccounts());
        client.setAccounts(accounts);
        return client;
    }

    public ClientResponseDto toDto(Client client) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setFirstName(client.getFirstName());
        clientResponseDto.setLastName(client.getLastName());
        clientResponseDto.setId(client.getId());
        List<AccountResponseDto> accountResponseDtos = accountMapper.toDto(client.getAccounts());
        clientResponseDto.setAccounts(accountResponseDtos);
        return clientResponseDto;
    }
}
