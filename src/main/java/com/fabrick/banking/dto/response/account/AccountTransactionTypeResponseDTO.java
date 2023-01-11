package com.fabrick.banking.dto.response.account;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountTransactionTypeResponseDTO {

    private String enumeration;
    private String value;
}
