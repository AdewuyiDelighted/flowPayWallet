package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import com.example.flowpaywallet.dto.requests.PaystackInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WalletService {

    String createWallet(CreateWalletRequest createWalletRequest);
}
