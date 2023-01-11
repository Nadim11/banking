package com.fabrick.banking.feign.response.account;

import com.fabrick.banking.feign.response.ClientResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccountBalanceBaseResponse implements ClientResponse {

    private String status;
    private List<Object> error;

}
