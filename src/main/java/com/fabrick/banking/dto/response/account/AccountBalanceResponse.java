package com.fabrick.banking.dto.response.account;


import com.fabrick.banking.dto.response.Response;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountBalanceResponse implements Response {

    private String                      status;
    private AccountBalanceResponseDTO   payload;
}
