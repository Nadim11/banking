package com.fabrick.banking.feign.model.response.account;

import com.fabrick.banking.feign.model.response.BaseClientResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountBalanceClientResponse extends BaseClientResponse {

    private AccountBalancePayload payload;
}
