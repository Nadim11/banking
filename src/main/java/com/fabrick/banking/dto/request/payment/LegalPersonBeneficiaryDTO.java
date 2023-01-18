package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.dto.DTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LegalPersonBeneficiaryDTO implements DTO {

    private String fiscalCode;
    private String legalRepresentativeFiscalCode;
}
