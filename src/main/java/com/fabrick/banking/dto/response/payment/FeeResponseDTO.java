package com.fabrick.banking.dto.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class FeeResponseDTO {

    private String      feeCode;
    private String      description;
    private BigDecimal  amount;
    private String      currency;
}
