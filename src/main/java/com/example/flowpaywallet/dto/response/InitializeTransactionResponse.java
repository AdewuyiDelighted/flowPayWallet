package com.example.flowpaywallet.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class InitializeTransactionResponse {

    private boolean status;
    private String message;
    private Data data;


}
