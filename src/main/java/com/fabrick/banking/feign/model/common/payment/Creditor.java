package com.fabrick.banking.feign.model.common.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Creditor {

    private String  name;
    private Account account;
    private Address address;
}
