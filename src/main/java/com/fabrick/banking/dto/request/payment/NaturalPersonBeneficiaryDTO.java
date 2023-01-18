package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.dto.DTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NaturalPersonBeneficiaryDTO implements DTO {

    private String fiscalCode1;
    private String fiscalCode2;
    private String fiscalCode3;
    private String fiscalCode4;
    private String fiscalCode5;
}
