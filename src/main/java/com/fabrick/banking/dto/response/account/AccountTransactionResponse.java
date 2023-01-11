package com.fabrick.banking.dto.response.account;

import com.fabrick.banking.dto.response.Response;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionResponse implements Response {

    private String                  status;
    private AccountTransactionList  payload;
}
