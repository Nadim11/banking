package com.fabrick.banking.controller.payment;

import com.fabrick.banking.controller.PaymentTransferController;
import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.dto.response.payment.PaymentTransferResponse;
import com.fabrick.banking.service.payment.PaymentTransferServiceImpl;
import com.fabrick.banking.util.PaymentTransferRequestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.fabrick.banking.constant.APIConstant.PaymentMoneyTransfer.BASE_URL;
import static com.fabrick.banking.constant.APIConstant.PaymentMoneyTransfer.MONEY_TRANSFER;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentTransferController.class)
class PaymentTransferControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentTransferServiceImpl paymentTransferService;

    @Test
    void test_create_money_transfer_should_return_success() throws Exception {
        when(paymentTransferService.createPaymentTransfer(Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                .thenReturn(new PaymentTransferResponse());

        PaymentTransferRequest paymentTransferRequest = PaymentTransferRequestBuilder.getValidRequest();

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post(BASE_URL + MONEY_TRANSFER, "14537780")
                        .content(asJsonString(paymentTransferRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }
    @Test
    void test_create_money_transfer_should_return_badRequest() throws Exception {
        when(paymentTransferService.createPaymentTransfer(Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                .thenReturn(new PaymentTransferResponse());

        this.mockMvc.perform( MockMvcRequestBuilders
                        .post(BASE_URL + MONEY_TRANSFER, "14537780")
                        .content(asJsonString(new PaymentTransferRequest()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
