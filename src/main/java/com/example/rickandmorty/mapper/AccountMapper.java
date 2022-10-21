package com.example.rickandmorty.mapper;

import com.example.rickandmorty.dto.AccountRequestDto;
import com.example.rickandmorty.dto.AccountResponseDto;
import com.example.rickandmorty.entity.Account;
import com.example.rickandmorty.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account toEntity(AccountRequestDto requestDto) {
        Account account = new Account();
        account.setBalance(requestDto.getBalance());
        account.setNumber(requestDto.getNumber());
        account.setType(requestDto.getType());
        return account;
    }

    public Account toEntity(AccountRequestDto requestDto, Client client) {
        Account account = new Account();
        account.setBalance(requestDto.getBalance());
        account.setNumber(requestDto.getNumber());
        account.setType(requestDto.getType());
        account.setClient(client);
        return account;
    }

    public AccountResponseDto toDto(Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setBalance(account.getBalance());
        accountResponseDto.setNumber(account.getNumber());
        accountResponseDto.setType(account.getType());
        accountResponseDto.setId(account.getId());
        return accountResponseDto;
    }
}
