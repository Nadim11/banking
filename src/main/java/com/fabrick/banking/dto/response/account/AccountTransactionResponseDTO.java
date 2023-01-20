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
public class AccountTransactionResponseDTO implements DTO {

    private String                              transactionId;
    private String                              operationId;
    private LocalDate                           accountingDate;
    private LocalDate                           valueDate;
    private AccountTransactionTypeResponseDTO   type;
    private BigDecimal                          amount;
    private String                              currency;
    private String                              description;
}
