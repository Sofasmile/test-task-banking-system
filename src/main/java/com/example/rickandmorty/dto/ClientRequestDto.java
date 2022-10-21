package com.example.rickandmorty.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientRequestDto {
    private String firstName;
    private String lastName;
    private List<AccountRequestDto> accounts;
}
