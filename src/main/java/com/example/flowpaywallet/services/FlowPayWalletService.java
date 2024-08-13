package com.example.flowpaywallet.services;

import com.example.flowpaywallet.data.model.Wallet;
import com.example.flowpaywallet.data.respository.WalletRepository;
import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FlowPayWalletService implements WalletService{
    private WalletRepository walletRepository;
    @Override
    public String createWallet(CreateWalletRequest createWalletRequest) {
        String accountNumber = generateAccountNumber();
        Wallet wallet = new Wallet();
        wallet.setAccountNumber(accountNumber);
        wallet.setBalance(BigDecimal.ZERO);
        walletRepository.save(wallet);
        return wallet.getAccountNumber();
    }
    private String generateAccountNumber() {
        return "2120";
    }

}
