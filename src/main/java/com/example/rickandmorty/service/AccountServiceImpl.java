package com.example.rickandmorty.service;

import com.example.rickandmorty.entity.Account;
import com.example.rickandmorty.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> saveAll(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }
}
