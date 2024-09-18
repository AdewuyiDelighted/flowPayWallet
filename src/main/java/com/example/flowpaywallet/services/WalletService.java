package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.CreateWalletRequest;

public interface WalletService {

    String createWallet(CreateWalletRequest createWalletRequest);
}
