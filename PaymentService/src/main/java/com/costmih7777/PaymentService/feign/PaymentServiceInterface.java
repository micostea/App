package com.costmih7777.PaymentService.feign;

import com.costmih7777.PaymentService.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("RON-PAYMENT-SERVICE")
public interface PaymentServiceInterface {

    @PostMapping("/api/ron-payments/execute")
    public ResponseEntity<String> executePayment(@RequestBody PaymentRequest request);

}
