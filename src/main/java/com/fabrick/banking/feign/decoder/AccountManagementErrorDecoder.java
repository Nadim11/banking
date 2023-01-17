package com.fabrick.banking.feign.decoder;

import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;
import com.fabrick.banking.exception.BadRequestException;
import com.fabrick.banking.exception.ForbiddenException;
import com.fabrick.banking.exception.GenericException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Slf4j
public class AccountManagementErrorDecoder implements ErrorDecoder {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {

        try{
            if(response.status() == HttpStatus.FORBIDDEN.value()){
                return new ForbiddenException(buildErrorResponse(response));
            }else if(response.status() == HttpStatus.BAD_REQUEST.value()){
                return new BadRequestException(buildErrorResponse(response));
            }else{
                return new GenericException(buildErrorResponse(response));
            }

        }catch (Exception e){
            return new Exception();
        }
    }

    private ErrorReturnResponseDTO buildErrorResponse(Response response) throws IOException {
        String resp = Util.toString(response.body().asReader(Util.UTF_8));
        return mapper.readValue(resp, ErrorReturnResponseDTO.class);
    }
}
