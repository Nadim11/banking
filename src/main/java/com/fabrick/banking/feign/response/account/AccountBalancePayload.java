package com.fabrick.banking.feign.response.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountBalancePayload {

    private Date date;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private String currency;
}
