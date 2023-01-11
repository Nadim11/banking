package com.fabrick.banking.exception;

import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;

public class ForbiddenException extends GenericException{

    public ForbiddenException(ErrorReturnResponseDTO errorResponse){
        super(errorResponse);
    }
}
