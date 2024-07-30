package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.CreateWalletRequest;
import com.example.flowpaywallet.dto.response.CreateWalletResponse;

public interface WalletService {

    String createWallet(CreateWalletRequest createWalletRequest);
}
