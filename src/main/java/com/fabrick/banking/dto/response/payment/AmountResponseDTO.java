package com.fabrick.banking.dto.response.payment;


import com.fabrick.banking.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AmountResponseDTO implements DTO {

    private BigDecimal  debtorAmount;
    private String      debtorCurrency;
    private BigDecimal  creditorAmount;
    private String      creditorCurrency;
    private LocalDate   creditorCurrencyDate;
    private Integer     exchangeRate;
}
