package com.costmih7777.PaymentService.service;

import com.costmih7777.PaymentService.dao.PaymentRepository;
import com.costmih7777.PaymentService.dto.PaymentRequest;
import com.costmih7777.PaymentService.feign.PaymentServiceInterface;
import com.costmih7777.PaymentService.model.Payment;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PubSubTemplate pubSubTemplate;
    private final PaymentRepository paymentRepository;
    @Autowired
    PaymentServiceInterface paymentServiceInterface;


    //  private final RonPaymentClient ronPaymentClient;


    public String makeRonPayment(PaymentRequest request) {


        ResponseEntity<String> executePayment = paymentServiceInterface.executePayment(request);




        Payment payment = Payment.builder()
                .vendorId(request.getVendorId())
                .amount(request.getAmount())
                .accountIban(request.getAccountIban())
                .beneficiaryName(request.getBeneficiaryName())
                .currency(request.getCurrency())
                .paymentMethod(request.getPaymentMethod())
                .status("INITIATED")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        payment = paymentRepository.save(payment);

//        try {
//            // call the remote microservice
//            String response = ronPaymentClient.executePayment(request);
//            payment.setStatus("SUCCESS");
//            paymentRepository.save(payment);
//            return response;
//        } catch (Exception e) {
//            payment.setStatus("FAILED");
//            paymentRepository.save(payment);
//            throw new RuntimeException("Payment failed: " + e.getMessage());
//        }


        if (1==1){
            pubSubTemplate.publish("my-topic", "test");



        }


        return ("Payment done!");

    }
}
