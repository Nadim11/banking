package com.fabrick.banking.feign.model.response.account;

import com.fabrick.banking.feign.model.response.BaseClientResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountTransactionClientResponse extends BaseClientResponse {

    private AccountTransactionPayloadList payload;

}
