package com.fabrick.banking.dto.response.account;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountBalanceResponseDTO {

    private Date        date;
    private BigDecimal  balance;
    private BigDecimal  availableBalance;
    private String      currency;
}
