package com.fabrick.banking.feign.model.response.account;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountTransactionClientResponse extends AccountBalanceBaseResponse{

    private AccountTransactionPayloadList payload;

}
