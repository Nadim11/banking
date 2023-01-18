package com.fabrick.banking.dto.request.payment;

import com.fabrick.banking.dto.DTO;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO implements DTO {

    @Size(max = 40)
    private String address;
    private String city;
    //TODO check ISO 3166-1 alpha 2 standard
    private String countryCode;
}
