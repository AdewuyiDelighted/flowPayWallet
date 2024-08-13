package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.PaystackInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

public class PaymentGateWayServiceTest {
    @Autowired
    private PaymentGateWayService paymentGateWayService;
    @Test
    public void testThatWalletUserCanInitializeTransactionWithPaystack() throws JsonProcessingException {
        PaystackInitializeTransactionRequest paystackInitializeTransactionRequest = new PaystackInitializeTransactionRequest();
        paystackInitializeTransactionRequest.setEmail("firstUser1@gmail.com");
        paystackInitializeTransactionRequest.setAmount("2000");
        InitializeTransactionResponse initializeTransactionResponse =paymentGateWayService.initializeTransaction(paystackInitializeTransactionRequest);
        assertThat(initializeTransactionResponse).isNotNull();
        assertTrue(initializeTransactionResponse.isStatus());

    }
}
