package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LegalPersonBeneficiaryDTO {

    private String fiscalCode;
    private String legalRepresentativeFiscalCode;
}
