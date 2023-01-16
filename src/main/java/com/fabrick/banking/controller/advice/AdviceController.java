package com.fabrick.banking.controller.advice;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.dto.response.error.ErrorResponseDTO;
import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;
import com.fabrick.banking.enumerable.ErrorsEnum;
import com.fabrick.banking.exception.BadRequestException;
import com.fabrick.banking.exception.ForbiddenException;
import com.fabrick.banking.exception.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(ForbiddenException ex){
        return buildResponseEntity(HttpStatus.FORBIDDEN, ex);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(BadRequestException ex){
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(GenericException ex){
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(MethodArgumentNotValidException ex){
        return handleException(new BadRequestException(handleBindingAndMethodArgumentNotValidException(ex.getBindingResult())));
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(BindException ex){
        return handleException(new BadRequestException(handleBindingAndMethodArgumentNotValidException(ex.getBindingResult())));
    }
    private ErrorReturnResponseDTO handleBindingAndMethodArgumentNotValidException(BindingResult bindingResult){
        List<ErrorResponseDTO> fieldErrors = bindingResult
                .getFieldErrors()
                .stream()
                .map(err -> ErrorResponseDTO.builder()
                        .code(ErrorsEnum.INVALID_OR_MISSING_FIELD.name())
                        .description(err.getDefaultMessage())
                        .params(err.getField())
                        .build())
                .toList();

        List<ErrorResponseDTO> globalErrors = bindingResult
                .getGlobalErrors()
                .stream()
                .map(err -> ErrorResponseDTO.builder()
                        .code(ErrorsEnum.INVALID_OR_MISSING_FIELD.name())
                        .description(err.getDefaultMessage())
                        .build()
                )
                .toList();

        List<ErrorResponseDTO> errors = new ArrayList<>();
        errors.addAll(fieldErrors);
        errors.addAll(globalErrors);

        ErrorReturnResponseDTO errorResponse = new ErrorReturnResponseDTO();
        errorResponse.setStatus(ErrorConstant.KO);
        errorResponse.setErrors(errors);

        return errorResponse;
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(MissingRequestHeaderException ex){
        ErrorReturnResponseDTO errorReturnResponseDTO = ErrorReturnResponseDTO.builder()
                .status(ErrorConstant.KO)
                .errors(List.of(ErrorResponseDTO.builder()
                                .code(ErrorsEnum.MISSING_HEADER.name())
                                .description(ex.getMessage())
                                .params(ex.getHeaderName())
                        .build()))
                .build();
        return handleException(new BadRequestException(errorReturnResponseDTO));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(Exception ex){
        return handleException(new GenericException(buildExceptionErrorResponse()));
    }

    private <T extends GenericException> ResponseEntity<ErrorReturnResponseDTO> buildResponseEntity(HttpStatus status, T ex){
        ErrorReturnResponseDTO errorResponse = ErrorReturnResponseDTO.builder()
                .status(ex.getErrorResponse().getStatus())
                .errors(ex.getErrorResponse().getErrors())
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }
    private ErrorReturnResponseDTO buildExceptionErrorResponse(){
        return ErrorReturnResponseDTO
                .builder()
                .status(ErrorConstant.KO)
                .errors(
                        List.of(
                                ErrorResponseDTO.builder()
                                        .code(ErrorsEnum.INTERNAL_SERVER_ERROR.name())
                                        .description(ErrorsEnum.INTERNAL_SERVER_ERROR.getDescription())
                                        .build()
                        )
                )
                .build();
    }
}
