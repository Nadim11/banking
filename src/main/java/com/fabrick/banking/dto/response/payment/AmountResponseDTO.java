package com.fabrick.banking.dto.response.payment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AmountResponseDTO {

    private BigDecimal  debtorAmount;
    private String      debtorCurrency;
    private BigDecimal  creditorAmount;
    private String      creditorCurrency;
    private Date        creditorCurrencyDate;
    private Integer     exchangeRate;
}
