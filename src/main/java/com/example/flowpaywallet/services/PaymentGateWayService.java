package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.FlutterwaveInitializeTransactionRequest;
import com.example.flowpaywallet.dto.requests.PaystackInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentGateWayService {

    default InitializeTransactionResponse initializeTransaction(PaystackInitializeTransactionRequest paystackInitializeTransactionRequest) throws JsonProcessingException {
        return null;
    }

    default InitializeTransactionResponse initializeTransaction(FlutterwaveInitializeTransactionRequest flutterwaveInitializeTransactionRequest) throws JsonProcessingException {
        return null;
    }

}
