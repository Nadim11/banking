package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.dto.DTO;
import com.fabrick.banking.validation.payment.annotation.ValidBeneficiaryType;
import com.fabrick.banking.validation.payment.annotation.ValidTaxRelief;
import com.fabrick.banking.validation.payment.annotation.ValidTaxReliefType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ValidTaxRelief
public class TaxReliefDTO implements DTO {

    @ValidTaxReliefType
    private String                          taxReliefId;
    @NotNull(message = ErrorConstant.NOT_NULL)
    private Boolean                         isCondoUpgrade;
    @NotNull(message = ErrorConstant.NOT_NULL)
    private String                          creditorFiscalCode;
    @NotNull(message = ErrorConstant.NOT_NULL)
    @ValidBeneficiaryType
    private String                          beneficiaryType;
    private NaturalPersonBeneficiaryDTO     naturalPersonBeneficiary;
    private LegalPersonBeneficiaryDTO       legalPersonBeneficiary;
}
