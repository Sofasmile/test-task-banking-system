package com.example.rickandmorty.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<AccountResponseDto> accounts;
}
