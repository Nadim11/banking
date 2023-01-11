package com.fabrick.banking.mapper.request.payment;

import com.fabrick.banking.dto.DTOMapper;
import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.feign.model.request.payment.PaymentTransferClientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentTransferRequestMapper extends DTOMapper<PaymentTransferRequest, PaymentTransferClientRequest> {

    @Override
    PaymentTransferRequest toDTO(PaymentTransferClientRequest obj);

    @Override
    PaymentTransferClientRequest fromDTO(PaymentTransferRequest obj);
}
