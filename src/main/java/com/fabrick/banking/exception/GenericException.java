package com.fabrick.banking.exception;

import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class GenericException extends RuntimeException {

    private final ErrorReturnResponseDTO errorResponse;
}
