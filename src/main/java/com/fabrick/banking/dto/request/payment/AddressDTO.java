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
    private String countryCode;
}
