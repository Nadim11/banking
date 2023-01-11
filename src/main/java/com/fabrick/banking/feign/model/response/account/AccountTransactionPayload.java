package com.fabrick.banking.feign.model.response.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountTransactionPayload {

    private String                  transactionId;
    private String                  operationId;
    private Date                    accountingDate;
    private Date                    valueDate;
    private AccountTransactionType  type;
    private BigDecimal              amount;
    private String                  currency;
    private String                  description;
}
