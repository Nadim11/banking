package com.fabrick.banking.feign.decoder;

import com.fabrick.banking.feign.model.response.payment.PaymentTransferClientResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.fabrick.banking.feign.enumerable.ResponseType.PAYMENT_CREATE_MONEY_TRANSFER_RESPONSE;

public class PaymentDecoder implements Decoder {

    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        String resp = Util.toString(response.body().asReader(Util.UTF_8));
        if(PAYMENT_CREATE_MONEY_TRANSFER_RESPONSE.getName().equals(type.getTypeName())){
            return mapper.readValue(resp, PaymentTransferClientResponse.class);
        }

        return PaymentTransferClientResponse.builder().build();
    }
}
