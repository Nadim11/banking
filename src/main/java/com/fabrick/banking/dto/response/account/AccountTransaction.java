package com.fabrick.banking.dto.response.account;

import com.fabrick.banking.feign.response.account.AccountTransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransaction {

    private String                  transactionId;
    private String                  operationId;
    private LocalDate               accountingDate;
    private LocalDate               valueDate;
    private AccountTransactionType  type;
    private BigDecimal              amount;
    private String                  currency;
    private String                  description;
}
