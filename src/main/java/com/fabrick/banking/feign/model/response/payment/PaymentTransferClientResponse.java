package com.fabrick.banking.feign.model.response.payment;

import com.fabrick.banking.feign.model.response.BaseClientResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PaymentTransferClientResponse extends BaseClientResponse {

    private PaymentTransferClientPayload payload;

}
