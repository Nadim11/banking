package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.dto.request.Request;
import com.fabrick.banking.enumerable.FeeType;
import com.fabrick.banking.validation.payment.annotation.ValidFeeType;
import com.fabrick.banking.validation.payment.annotation.ValidPaymentTransferExecutionDate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ValidPaymentTransferExecutionDate
public class PaymentTransferRequest implements Request {

    @NotNull(message = ErrorConstant.NOT_NULL)
    @Valid
    private CreditorDTO     creditor;
    private LocalDate       executionDate;
    private String          uri;
    @NotNull(message = ErrorConstant.NOT_NULL)
    @Size(max = 140)
    private String          description;
    @NotNull(message = ErrorConstant.NOT_NULL)
    private BigDecimal      amount;
    @NotNull
    private String          currency;
    private Boolean         isUrgent;
    private Boolean         isInstant;
    @ValidFeeType
    private String          feeType;
    private String          feeAccountId;
    @Valid
    private TaxReliefDTO    taxRelief;

    public static class PaymentTransferRequestBuilder{
        private String      feeType = FeeType.SHA.name();
        private Boolean     isInstant = false;
    }
}
