package com.fabrick.banking.mapper.response.account;

import com.fabrick.banking.dto.ListDTOMapper;
import com.fabrick.banking.dto.response.account.AccountTransactionResponseDTO;
import com.fabrick.banking.entity.account.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTransactionDBResponseMapper extends ListDTOMapper<AccountTransactionResponseDTO, Transaction> {

    @Override
    List<AccountTransactionResponseDTO> toDTOList(List<Transaction> var1);

    @Override
    List<Transaction> fromDTOList(List<AccountTransactionResponseDTO> var1);
}
