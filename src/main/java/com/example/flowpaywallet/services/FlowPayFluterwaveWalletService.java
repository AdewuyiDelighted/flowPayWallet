package com.example.flowpaywallet.services;


import com.example.flowpaywallet.dto.requests.FlutterwaveInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public class FlowPayFluterwaveWalletService  implements PaymentGateWayService{


    @Override
    public InitializeTransactionResponse initializeTransaction(FlutterwaveInitializeTransactionRequest paystackInitializeTransactionRequest) throws JsonProcessingException {
        return null;
    }
}
