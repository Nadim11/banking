package com.fabrick.banking.dto.request.account;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.constant.PatternConstant;
import com.fabrick.banking.dto.request.Request;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionRequest implements Request {

    @NotNull(message = ErrorConstant.NOT_NULL)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = PatternConstant.YYYY_MM_DD)
    private LocalDate   fromAccountingDate;

    @NotNull(message = ErrorConstant.NOT_NULL)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = PatternConstant.YYYY_MM_DD)
    private LocalDate    toAccountingDate;
}
