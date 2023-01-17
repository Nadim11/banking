package com.fabrick.banking.feign.decoder;

import com.fabrick.banking.feign.enumerable.ResponseType;
import com.fabrick.banking.feign.model.response.account.AccountBalanceBaseResponse;
import com.fabrick.banking.feign.model.response.account.AccountBalanceClientResponse;
import com.fabrick.banking.feign.model.response.account.AccountTransactionClientResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
public class AccountManagementDecoder implements Decoder{

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        String resp = Util.toString(response.body().asReader(Util.UTF_8));

        if(ResponseType.ACCOUNT_BALANCE_CLIENT_RESPONSE.getName().equals(type.getTypeName())){
            return mapper.readValue(resp, AccountBalanceClientResponse.class);
        }
        else if(ResponseType.ACCOUNT_TRANSACTION_CLIENT_RESPONSE.getName().equals(type.getTypeName())){
            return mapper.readValue(resp, AccountTransactionClientResponse.class);
        }

        return AccountBalanceBaseResponse.builder().build();
    }
}
