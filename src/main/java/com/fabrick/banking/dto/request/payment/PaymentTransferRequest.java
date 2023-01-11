package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.dto.request.Request;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PaymentTransferRequest implements Request {

    private CreditorDTO     creditor;
    private Date            executionDate;
    private String          uri;
    private String          description;
    private BigDecimal      amount;
    private String          currency;
    private Boolean         isUrgent;
    private Boolean         isInstant;
    private String          feeType;
    private String          feeAccountId;
    private TaxReliefDTO    taxRelief;
}
