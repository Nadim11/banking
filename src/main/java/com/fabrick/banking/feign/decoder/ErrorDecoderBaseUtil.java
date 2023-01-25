package com.fabrick.banking.feign.decoder;

import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;
import com.fabrick.banking.exception.BadRequestException;
import com.fabrick.banking.exception.ForbiddenException;
import com.fabrick.banking.exception.GenericException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

abstract class ErrorDecoderBaseUtil implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response){
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

    public ErrorReturnResponseDTO buildErrorResponse(Response response) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(response.body().asInputStream()))) {
            String httpBodyResponse = reader.lines()
                    .collect(Collectors.joining(""));

            return mapper.readValue(httpBodyResponse, ErrorReturnResponseDTO.class);
        }
    }
}
