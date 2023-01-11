package com.fabrick.banking.feign.model.common.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Debtor {

    private String  name;
    private Account account;
}
