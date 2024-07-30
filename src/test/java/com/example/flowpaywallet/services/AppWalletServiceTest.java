package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.CreateWalletRequest;
import com.example.flowpaywallet.dto.requests.InitializeTransactionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@SpringBootTest
public class AppWalletServiceTest {
    @Autowired
    private WalletService walletService;

    @Test
    public void testThatOnlyUserCanCreateAWallet() {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setEmail("firstUser1@gmail.com");
        String accountNumber = walletService.createWallet(createWalletRequest);
        assertThat(accountNumber).isNotNull();

    }
//    test that accountNumberSAreUnquie
    @Test
    public void testThatWalletUserCanInitializeTransaction(){
        InitializeTransactionRequest initializeTransactionRequest = new InitializeTransactionRequest();
        initializeTransactionRequest.setEmail("firstUser1@gmail.com");
        initializeTransactionRequest.setAmount("2000");
//        walletService.initializeTransaction(initializeTransactionRequest);

    }
}
