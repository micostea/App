package com.costmih7777.RonPaymentService.Controller;

import com.costmih7777.RonPaymentService.model.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ron-payments")
public class RonPaymentController {

    //http://localhost:8080/api/ron-payments/execute
    /*
    {
  "accountIban": "RO49AAAA1B31007593840000",
  "amount": 150.75,
  "currency": "RON",
  "beneficiaryName": "Dorel"
   }
     */
    @PostMapping("/execute")
    public ResponseEntity<String> executePayment(@RequestBody PaymentRequest request) {
        // aici ai logica de apel catre ING (obtinere token, trimitere plata, etc.)
        System.out.println("Executing RON payment for: " + request);
        return ResponseEntity.ok("Payment executed successfully for " + request.getAccountIban());
    }
}
