package com.example.flowpaywallet.dto.response;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String customer_code;
    private String phone;
    private String metadata;
    private String risk_action;
    private String international_format_phone;
}
