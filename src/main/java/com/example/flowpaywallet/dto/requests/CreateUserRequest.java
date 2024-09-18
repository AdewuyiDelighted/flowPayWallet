package com.example.flowpaywallet.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    @NotNull(message = "FullName Is Mandatory")
    private String fullName;
    @NotNull(message = "Email Is Mandatory")
    private String email;
    @NotNull(message = "Email Is Mandatory")
    private String pin;
}
