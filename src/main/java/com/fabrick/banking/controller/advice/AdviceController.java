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
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(ForbiddenException ex){
        return buildResponseEntity(HttpStatus.FORBIDDEN, ex);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(BadRequestException ex){
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(GenericException ex){
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(MethodArgumentNotValidException ex){
        return handleException(new BadRequestException(handleBindingAndMethodArgumentNotValidException(ex.getBindingResult())));
    }
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(BindException ex){
        return handleException(new BadRequestException(handleBindingAndMethodArgumentNotValidException(ex.getBindingResult())));
    }
    private ErrorReturnResponseDTO handleBindingAndMethodArgumentNotValidException(BindingResult bindingResult){
        List<ErrorResponseDTO> fieldErrors = getFieldErrors(bindingResult.getFieldErrors());

        List<ErrorResponseDTO> globalErrors = getGlobalErrors(bindingResult.getGlobalErrors());

        List<ErrorResponseDTO> errors = new ArrayList<>();
        errors.addAll(fieldErrors);
        errors.addAll(globalErrors);

        ErrorReturnResponseDTO errorResponse = new ErrorReturnResponseDTO();
        errorResponse.setStatus(ErrorConstant.KO);
        errorResponse.setErrors(errors);

        return errorResponse;
    }

    private List<ErrorResponseDTO> getFieldErrors(List<FieldError> fieldErrors){
        return fieldErrors
                .stream()
                .map(err -> ErrorResponseDTO.builder()
                        .code(ErrorsEnum.INVALID_OR_MISSING_FIELD.name())
                        .description(err.getDefaultMessage())
                        .params(err.getField())
                        .build())
                .toList();
    }

    private List<ErrorResponseDTO> getGlobalErrors(List<ObjectError> globalErrors){
        return globalErrors
                .stream()
                .map(err -> ErrorResponseDTO.builder()
                        .code(ErrorsEnum.INVALID_OR_MISSING_FIELD.name())
                        .description(err.getDefaultMessage())
                        .build())
                .toList();
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
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
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorReturnResponseDTO> handleException(Exception ex){
        return handleException(new GenericException(buildExceptionErrorResponse()));
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

    private <T extends GenericException> ResponseEntity<ErrorReturnResponseDTO> buildResponseEntity(HttpStatus status, T ex){
        ErrorReturnResponseDTO errorResponse = ErrorReturnResponseDTO.builder()
                .status(ex.getErrorResponse().getStatus())
                .errors(ex.getErrorResponse().getErrors())
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }
}
