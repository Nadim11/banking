package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TaxReliefDTO {

    private String                          taxReliefId;
    private Boolean                         isCondoUpgrade;
    private String                          creditorFiscalCode;
    private String                          beneficiaryType;
    private NaturalPersonBeneficiaryDTO     naturalPersonBeneficiary;
    private LegalPersonBeneficiaryDTO       legalPersonBeneficiary;
}
