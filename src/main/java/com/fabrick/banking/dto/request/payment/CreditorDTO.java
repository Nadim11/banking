package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreditorDTO {

    private String  name;
    private AccountDTO account;
    private AddressDTO address;
}
