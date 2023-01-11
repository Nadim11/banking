package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DebtorDTO {

    private String  name;
    private AccountDTO account;
}
