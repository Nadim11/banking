package com.fabrick.banking.mapper.request.account;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.request.account.AccountTransactionRequest;
import com.fabrick.banking.feign.model.request.account.AccountTransactionClientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTransactionRequestMapper extends DTOMapper<AccountTransactionRequest, AccountTransactionClientRequest> {

    @Override
    AccountTransactionRequest       toDTO(AccountTransactionClientRequest obj);

    @Override
    AccountTransactionClientRequest fromDTO(AccountTransactionRequest obj);
}
