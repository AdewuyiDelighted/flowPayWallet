package com.example.flowpaywallet.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateWalletRequest {
    private Long appUserId;
    private String pin;

}
