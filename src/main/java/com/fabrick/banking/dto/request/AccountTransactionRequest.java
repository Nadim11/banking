package com.fabrick.banking.dto.request;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.deserializer.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionRequest implements Request{

    @NotNull(message = ErrorConstant.NOT_NULL)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate fromAccountingDate;

    @NotNull(message = ErrorConstant.NOT_NULL)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate toAccountingDate;
}
