package com.fabrick.banking.mapper.response;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.feign.response.account.AccountTransactionClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTransactionResponseMapper extends DTOMapper<AccountTransactionResponse, AccountTransactionClientResponse> {
}
