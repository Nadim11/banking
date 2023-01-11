package com.fabrick.banking.feign.model.common.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Address {

    private String address;
    private String city;
    private String countryCode;
}
