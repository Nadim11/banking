package com.fabrick.banking.dto.request.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO {

    private String address;
    private String city;
    private String countryCode;
}
