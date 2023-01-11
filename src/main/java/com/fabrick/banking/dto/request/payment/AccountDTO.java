package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccountDTO {

    private String accountCode;
    private String bicCode;
}
