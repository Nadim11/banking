package com.fabrick.banking.dto.response.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccountResponseDTO {

    private String accountCode;
    private String bicCode;
}
