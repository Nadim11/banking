package com.fabrick.banking.dto.response.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DebtorResponseDTO {

    private String  name;
    private AccountResponseDTO account;
}
