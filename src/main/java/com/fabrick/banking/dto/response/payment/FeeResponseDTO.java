package com.fabrick.banking.dto.response.payment;

import com.fabrick.banking.dto.DTO;
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
public class FeeResponseDTO implements DTO {

    private String      feeCode;
    private String      description;
    private BigDecimal  amount;
    private String      currency;
}
