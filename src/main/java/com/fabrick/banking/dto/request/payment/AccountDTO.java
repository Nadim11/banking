package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.dto.DTO;
import com.fabrick.banking.validation.payment.annotation.ValidAccount;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ValidAccount
public class AccountDTO implements DTO {

    @NotNull(message = ErrorConstant.NOT_NULL)
    private String accountCode;
    private String bicCode;
}
