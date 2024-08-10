package com.example.flowpaywallet.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    private String fullName;
    private String email;
}