package com.example.flowpaywallet.dto.response;


import lombok.Getter;
import lombok.Setter;


@lombok.Data
public class Data {
    private String authorization_url;
    private String access_code;
    private String reference;

}
