package com.example.rickandmorty.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequestDto {
    private String number;
    private String type;
    private BigDecimal balance;
}
