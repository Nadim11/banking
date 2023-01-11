package com.fabrick.banking.feign.model.request.payment;

import com.fabrick.banking.feign.model.common.payment.Creditor;
import com.fabrick.banking.feign.model.request.ClientRequest;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PaymentTransferClientRequest implements ClientRequest {

    private Creditor    creditor;
    private Date        executionDate;
    private String      uri;
    private String      description;
    private BigDecimal  amount;
    private String      currency;
    private Boolean     isUrgent;
    private Boolean     isInstant;
    private String      feeType;
    private String      feeAccountId;
    private TaxRelief   taxRelief;
}
