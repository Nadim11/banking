package com.fabrick.banking.dto.response.payment;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddressResponseDTO {

    private String address;
    private String city;
    private String countryCode;
}
