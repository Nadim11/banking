package com.fabrick.banking.dto.response.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreditorResponseDTO {

    private String              name;
    private AccountResponseDTO  account;
    private AddressResponseDTO  address;
}
