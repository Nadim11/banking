package com.fabrick.banking.feign.model.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TaxRelief {

    private String                      taxReliefId;
    private Boolean                     isCondoUpgrade;
    private String                      creditorFiscalCode;
    private String                      beneficiaryType;
    private NaturalPersonBeneficiary    naturalPersonBeneficiary;
    private LegalPersonBeneficiary      legalPersonBeneficiary;
}
