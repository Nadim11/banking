package com.fabrick.banking.dto.response.error;

import com.fabrick.banking.dto.response.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorReturnResponseDTO implements Response {

    private String                  status;
    private List<ErrorResponseDTO>  errors;
}
