package com.fabrick.banking.feign.model.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LegalPersonBeneficiary {

    private String fiscalCode;
    private String legalRepresentativeFiscalCode;
}
