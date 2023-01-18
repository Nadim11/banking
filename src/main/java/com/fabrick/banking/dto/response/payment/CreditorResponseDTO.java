package com.fabrick.banking.dto.response.payment;

import com.fabrick.banking.dto.DTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreditorResponseDTO implements DTO {

    private String              name;
    private AccountResponseDTO  account;
    private AddressResponseDTO  address;
}
