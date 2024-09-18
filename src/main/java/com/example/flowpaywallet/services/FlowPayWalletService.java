package com.example.flowpaywallet.services;

import com.example.flowpaywallet.data.model.AppUser;
import com.example.flowpaywallet.data.model.Wallet;
import com.example.flowpaywallet.data.respository.AppUserRepository;
import com.example.flowpaywallet.data.respository.WalletRepository;
import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FlowPayWalletService implements WalletService{
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public String createWallet(CreateWalletRequest createWalletRequest) {
        String accountNumber = generateAccountNumber();

        Wallet wallet = new Wallet();
        wallet.setAccountNumber(accountNumber);
        wallet.setPin(createWalletRequest.getPin());
        AppUser appUser = appUserRepository.getReferenceById(createWalletRequest.getAppUserId());
        wallet.setAppUser(appUser);
        walletRepository.save(wallet);

        return wallet.getAccountNumber();
    }
    private String generateAccountNumber() {
        return "2120";
    }

}
