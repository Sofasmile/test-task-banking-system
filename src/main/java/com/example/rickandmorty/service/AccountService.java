package com.example.rickandmorty.service;

import com.example.rickandmorty.entity.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);

    List<Account> saveAll(List<Account> accounts);
}
