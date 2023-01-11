package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NaturalPersonBeneficiaryDTO {

    private String fiscalCode1;
    private String fiscalCode2;
    private String fiscalCode3;
    private String fiscalCode4;
    private String fiscalCode5;
}
