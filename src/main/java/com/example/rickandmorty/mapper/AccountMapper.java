package com.example.rickandmorty.mapper;

import com.example.rickandmorty.dto.AccountRequestDto;
import com.example.rickandmorty.dto.AccountResponseDto;
import com.example.rickandmorty.entity.Account;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public Account toEntity(AccountRequestDto requestDto) {
        Account account = new Account();
        account.setBalance(requestDto.getBalance());
        account.setNumber(requestDto.getNumber());
        account.setType(requestDto.getType());
        return account;
    }

    public List<Account> toEntity(List<AccountRequestDto> requestDtos) {
        return requestDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public AccountResponseDto toDto(Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setBalance(account.getBalance());
        accountResponseDto.setNumber(account.getNumber());
        accountResponseDto.setType(account.getType());
        accountResponseDto.setId(account.getId());
        return accountResponseDto;
    }

    public List<AccountResponseDto> toDto(List<Account> accounts) {
        return accounts.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
