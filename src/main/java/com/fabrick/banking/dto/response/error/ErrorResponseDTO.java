package com.fabrick.banking.dto.response.error;

import com.fabrick.banking.dto.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponseDTO implements DTO {

    private String code;
    private String description;
    private String params;
}
