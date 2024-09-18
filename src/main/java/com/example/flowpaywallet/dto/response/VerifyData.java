package com.example.flowpaywallet.dto.response;


import lombok.Data;

@Data
public class VerifyData {
    private Long id;
    private String domain;
    private String status;
    private String reference;
    private String receipt_number;
    private String amount;
    private String message;
    private String gateway_response;
    private String paid_at;
    private String created_at;
    private String channel;
    private String currency;
    private String ip_address;
    private String metadata;
    private Log log;
    private int fees;
    private String fees_split;
    private Authorization authorization;
    private Customer customer;
    private String plan;
    private String order_id;
    private Split split;
    private String paidAt;
    private String createdAt;
    private String requested_amount;
    private String pos_transaction_data;
    private String source;
    private String fees_breakdown;
    private String connect;
    private String transaction_date;
    private PlanObject plan_object;
    private SubAccount  subaccount;

    //                "paidAt": "2024-08-22T09:15:02.000Z",
//                "createdAt": "2024-08-22T09:14:24.000Z",
//                "requested_amount": 30050,
//                "pos_transaction_data": null,
//                "source": null,
//                "fees_breakdown": null,
//                "connect": null,
//                "transaction_date": "2024-08-22T09:14:24.000Z",
//                "plan_object": {},
//        "subaccount": {}
//


}
