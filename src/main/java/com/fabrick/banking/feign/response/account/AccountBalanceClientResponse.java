package com.fabrick.banking.feign.response.account;

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
public class AccountBalanceClientResponse extends AccountBalanceBaseResponse{

    private AccountBalancePayload payload;
}
