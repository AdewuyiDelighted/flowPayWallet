package com.example.flowpaywallet.services;

import com.example.flowpaywallet.dto.requests.CreateWalletRequest;
import com.example.flowpaywallet.dto.requests.PaystackInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
