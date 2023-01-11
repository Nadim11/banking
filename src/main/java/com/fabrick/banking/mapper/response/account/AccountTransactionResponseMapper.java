package com.fabrick.banking.mapper.response.account;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.feign.model.response.account.AccountTransactionClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTransactionResponseMapper extends DTOMapper<AccountTransactionResponse, AccountTransactionClientResponse> {

    @Override
    AccountTransactionResponse      toDTO(AccountTransactionClientResponse obj);

    @Override
    AccountTransactionClientResponse fromDTO(AccountTransactionResponse obj);
}
