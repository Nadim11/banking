package com.fabrick.banking.dto.response.account;

import com.fabrick.banking.dto.DTO;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountBalanceResponseDTO implements DTO {

    private LocalDate   date;
    private BigDecimal  balance;
    private BigDecimal  availableBalance;
    private String      currency;
}
