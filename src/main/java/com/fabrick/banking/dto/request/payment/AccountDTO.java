package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.validation.annotation.ValidAccount;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ValidAccount
public class AccountDTO {

    @NotNull(message = ErrorConstant.NOT_NULL)
    private String accountCode;
    private String bicCode;
}
