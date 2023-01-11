package com.fabrick.banking.feign.request;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionClientRequest implements ClientRequest{

    private LocalDate fromAccountingDate;
    private LocalDate toAccountingDate;
}
