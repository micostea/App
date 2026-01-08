package com.costmih7777.PaymentService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Long vendorId;
    private String accountIban;
    private String beneficiaryName;
    private BigDecimal amount;
    private String currency;
    private String paymentMethod;
}

