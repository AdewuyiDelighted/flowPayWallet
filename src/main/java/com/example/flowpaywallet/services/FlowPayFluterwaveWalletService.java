package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import com.example.flowpaywallet.dto.requests.InitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public class FlowPayFluterwaveWalletService  implements WalletService{
    @Override
    public String createWallet(CreateWalletRequest createWalletRequest) {
        return null;
    }

    @Override
    public InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest) throws JsonProcessingException {
        return null;
    }
}
