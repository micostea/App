package com.costmih7777.RonPaymentService.model;


import lombok.Data;

@Data
public class PaymentRequest {
    private String accountIban;
    private Double amount;
    private String currency;
    private String beneficiaryName;
}

