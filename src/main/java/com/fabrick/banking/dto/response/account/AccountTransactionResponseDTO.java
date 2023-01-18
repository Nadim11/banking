package com.fabrick.banking.dto.response.account;

import com.fabrick.banking.dto.DTO;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionResponseDTO implements DTO {

    private String                              transactionId;
    private String                              operationId;
    private Date                                accountingDate;
    private Date                                valueDate;
    private AccountTransactionTypeResponseDTO   type;
    private BigDecimal                          amount;
    private String                              currency;
    private String                              description;
}
