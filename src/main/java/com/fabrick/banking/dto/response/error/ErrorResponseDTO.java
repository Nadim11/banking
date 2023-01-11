package com.fabrick.banking.dto.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponseDTO {

    private String code;
    private String description;
    private String params;
}
