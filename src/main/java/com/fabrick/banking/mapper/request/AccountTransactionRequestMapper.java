package com.fabrick.banking.mapper.request;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.request.AccountTransactionRequest;
import com.fabrick.banking.feign.request.AccountTransactionClientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTransactionRequestMapper extends DTOMapper<AccountTransactionRequest, AccountTransactionClientRequest> {
}
