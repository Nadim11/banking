package com.fabrick.banking.dto.response.payment;

import com.fabrick.banking.dto.response.Response;
import com.fabrick.banking.feign.model.common.payment.Creditor;
import com.fabrick.banking.feign.model.common.payment.Debtor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PaymentTransferResponse implements Response {

    private String                      moneyTransferId;
    private String                      status;
    private String                      direction;
    private CreditorResponseDTO         creditor;
    private DebtorResponseDTO           debtor;
    private String                      cro;
    private String                      uri;
    private String                      trn;
    private String                      description;
    private LocalDateTime               createdDatetime;
    private LocalDateTime               accountedDatetime;
    private Date                        debtorValueDate;
    private Date                        creditorValueDate;
    private AmountResponseDTO           amount;
    private Boolean                     isUrgent;
    private Boolean                     isInstant;
    private String                      feeType;
    private String                      feeAccountId;
    private List<FeeResponseDTO>        fees;
    private Boolean                     hasTaxRelief;

}
