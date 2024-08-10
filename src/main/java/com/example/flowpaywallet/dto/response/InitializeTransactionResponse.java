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

//    {
//        "status": true,
//            "message": "Authorization URL created",
//            "data": {
//        "authorization_url": "https://checkout.paystack.com/nkdks46nymizns7",
//                "access_code": "nkdks46nymizns7",
//                "reference": "nms6uvr1pl"
//    }
}
