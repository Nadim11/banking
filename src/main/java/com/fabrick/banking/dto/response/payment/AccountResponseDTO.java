package com.fabrick.banking.dto.response.payment;

import com.fabrick.banking.dto.DTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccountResponseDTO implements DTO {

    private String accountCode;
    private String bicCode;
}
