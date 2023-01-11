package com.fabrick.banking.dto.response.account;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountBalance {

    private LocalDate   date;
    private BigDecimal  balance;
    private BigDecimal  availableBalance;
    private String      currency;
}
