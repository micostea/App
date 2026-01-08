package com.costmih7777.PaymentService.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "PAYMENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "VENDOR_ID")
    private Long vendorId;

    @Column(name = "IBAN")
    private String accountIban;

    @Column(name = "BENEFICIARY_NAME")
    private String beneficiaryName;

    @Column(name = "AMOUNT", precision = 12, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "CURRENCY", length = 5)
    private String currency;

    @Column(name = "PAYMENT_METHOD", length = 400)
    private String paymentMethod;

    @Column(name = "STATUS", length = 400)
    private String status;

    @Column(name = "TRANSACTION_REF", length = 400)
    private String transactionRef;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
