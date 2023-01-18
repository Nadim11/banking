package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.dto.DTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreditorDTO implements DTO {

    @NotNull(message = ErrorConstant.NOT_NULL)
    @Size(max = 70)
    private String      name;
    @NotNull(message = ErrorConstant.NOT_NULL)
    @Valid
    private AccountDTO  account;
    @Valid
    private AddressDTO  address;
}
