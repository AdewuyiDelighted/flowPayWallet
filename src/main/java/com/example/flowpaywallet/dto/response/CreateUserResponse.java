package com.example.flowpaywallet.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserResponse {
    private String message;
    private String accountNumber;
}
