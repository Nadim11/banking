package com.fabrick.banking.mapper.response.payment;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.response.payment.PaymentTransferResponse;
import com.fabrick.banking.feign.model.response.payment.PaymentTransferClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentTransferResponseMapper extends DTOMapper<PaymentTransferResponse, PaymentTransferClientResponse> {

    @Override
    PaymentTransferResponse toDTO(PaymentTransferClientResponse obj);

    @Override
    PaymentTransferClientResponse fromDTO(PaymentTransferResponse obj);
}
