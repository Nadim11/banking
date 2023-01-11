package com.fabrick.banking.feign.model.common.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Account {

    private String accountCode;
    private String bicCode;
}
