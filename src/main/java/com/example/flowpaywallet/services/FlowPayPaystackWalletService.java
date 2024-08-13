package com.example.flowpaywallet.services;

import com.example.flowpaywallet.data.respository.WalletRepository;
import com.example.flowpaywallet.dto.requests.PaystackInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class FlowPayPaystackWalletService implements PaymentGateWayService {
    private final WalletRepository walletRepository;
    @Value("${paystack_secret_key}")
    private String secretkey;




    @Override
    public InitializeTransactionResponse initializeTransaction(PaystackInitializeTransactionRequest paystackInitializeTransactionRequest) {
//        find walllet by accountNumber
        HttpClient client = HttpClient.newHttpClient();
        InitializeTransactionResponse transactionResponse = new InitializeTransactionResponse();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestString = objectMapper.writeValueAsString(paystackInitializeTransactionRequest);

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.paystack.co/transaction/initialize"))
                    .header("Authorization", "Bearer " + secretkey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestString))
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMappers = new ObjectMapper();
            transactionResponse = objectMappers.readValue(response.body(), InitializeTransactionResponse.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return transactionResponse;
    }


}
