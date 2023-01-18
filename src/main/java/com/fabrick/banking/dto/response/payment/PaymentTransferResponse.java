package com.fabrick.banking.dto.response.payment;

import com.fabrick.banking.dto.response.Response;
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
public class PaymentTransferResponse implements Response {

    private String                      status;
    private PaymentTransferPayloadDTO   payload;

}
