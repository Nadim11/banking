package com.fabrick.banking.dto.response.payment;

import com.fabrick.banking.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PaymentTransferPayloadDTO implements DTO {

    private String                      moneyTransferId;
    private String                      status;
    private String                      direction;
    private CreditorResponseDTO         creditor;
    private DebtorResponseDTO           debtor;
    private String                      cro;
    private String                      uri;
    private String                      trn;
    private String                      description;
    private String                      createdDatetime;
    private String                      accountedDatetime;
    private LocalDate                   debtorValueDate;
    private LocalDate                   creditorValueDate;
    private AmountResponseDTO           amount;
    private Boolean                     isUrgent;
    private Boolean                     isInstant;
    private String                      feeType;
    private String                      feeAccountId;
    private List<FeeResponseDTO>        fees;
    private Boolean                     hasTaxRelief;
}
