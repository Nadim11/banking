package com.fabrick.banking.mapper.response.account;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.feign.model.response.account.AccountBalanceClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountBalanceResponseMapper extends DTOMapper<AccountBalanceResponse, AccountBalanceClientResponse> {

    @Override
    AccountBalanceResponse          toDTO(AccountBalanceClientResponse obj);

    @Override
    AccountBalanceClientResponse    fromDTO(AccountBalanceResponse obj);
}
