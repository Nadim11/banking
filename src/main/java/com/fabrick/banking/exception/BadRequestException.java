package com.fabrick.banking.exception;

import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;

public class BadRequestException extends GenericException{

    public BadRequestException(ErrorReturnResponseDTO errorResponse){
        super(errorResponse);
    }
}
