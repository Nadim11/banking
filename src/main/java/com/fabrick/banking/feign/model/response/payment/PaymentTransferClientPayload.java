package com.fabrick.banking.feign.model.response.payment;

import com.fabrick.banking.feign.model.common.payment.Creditor;
import com.fabrick.banking.feign.model.common.payment.Debtor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PaymentTransferClientPayload {

    private String          moneyTransferId;
    private String          status;
    private String          direction;
    private Creditor        creditor;
    private Debtor          debtor;
    private String          cro;
    private String          uri;
    private String          trn;
    private String          description;
    private String          createdDatetime;
    private String          accountedDatetime;
    private Date            debtorValueDate;
    private Date            creditorValueDate;
    private Amount          amount;
    private Boolean         isUrgent;
    private Boolean         isInstant;
    private String          feeType;
    private String          feeAccountId;
    private List<Fee>       fees;
    private Boolean         hasTaxRelief;
}
