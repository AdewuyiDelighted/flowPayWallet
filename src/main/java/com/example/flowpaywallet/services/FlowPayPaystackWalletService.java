package com.example.flowpaywallet.services;

import com.example.flowpaywallet.data.respository.WalletRepository;
import com.example.flowpaywallet.dto.requests.PaystackInitializeTransactionRequest;
import com.example.flowpaywallet.dto.response.InitializeTransactionResponse;
import com.example.flowpaywallet.dto.response.VerifyTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
            String convertedAmount = convertAmount(paystackInitializeTransactionRequest.getAmount());
            paystackInitializeTransactionRequest.setAmount(convertedAmount);

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

            System.out.println("Transaction Response " + transactionResponse.getData());
            if (transactionResponse.isStatus()) {
                VerifyTransaction verifyTransaction = verifyTransaction(transactionResponse.getData().getReference());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return transactionResponse;
    }

    private VerifyTransaction verifyTransaction(String reference) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        VerifyTransaction verifyTransaction;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.paystack.co/transaction/verify/" + reference))
                .header("Authorization", "Bearer " + secretkey)
                .GET()
                .build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMappers = new ObjectMapper();
        verifyTransaction = objectMappers.readValue(response.body(), VerifyTransaction.class);

        System.out.println(verifyTransaction);

        return  verifyTransaction;
    }

    private String convertAmount(String amount) {
        int stringToInt = Integer.parseInt(amount);
        return String.valueOf(stringToInt * 100);
    }


}
