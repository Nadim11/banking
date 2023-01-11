package com.fabrick.banking.mapper.response;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.feign.response.account.AccountBalanceClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountBalanceResponseMapper extends DTOMapper<AccountBalanceResponse, AccountBalanceClientResponse> {
}
