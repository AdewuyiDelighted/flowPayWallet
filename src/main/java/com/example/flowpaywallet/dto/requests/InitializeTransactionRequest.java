package com.example.flowpaywallet.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InitializeTransactionRequest {
    private String email;
    private String amount;
}
