package com.fabrick.banking.service.payment;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.dto.response.payment.PaymentTransferResponse;
import com.fabrick.banking.feign.client.PaymentTransferClient;
import com.fabrick.banking.mapper.request.payment.PaymentTransferRequestMapperImpl;
import com.fabrick.banking.mapper.response.payment.PaymentTransferResponseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentTransferServiceImpl implements PaymentTransferService{

    private final PaymentTransferClient             paymentTransferClient;
    private final PaymentTransferRequestMapperImpl  paymentTransferRequestMapper;
    private final PaymentTransferResponseMapperImpl paymentTransferResponseMapper;

    @Override
    public PaymentTransferResponse createPaymentTransfer(String xTimeZone, String accountId, PaymentTransferRequest request) {
        return paymentTransferResponseMapper
                .toDTO(
                        paymentTransferClient.createPaymentTransfer(
                                xTimeZone,
                                accountId,
                                paymentTransferRequestMapper.fromDTO(request)
                        )
                );
    }
}
