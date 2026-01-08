package com.costmih7777.PaymentService.controller;



import com.costmih7777.PaymentService.dto.PaymentRequest;
import com.costmih7777.PaymentService.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {


    private final PaymentService paymentService;

  /*
  http://localhost:8080/payments/ron
  {
  "vendorId": 2,
  "accountIban":"RO49AAAA1B31007593840000",
  "beneficiaryName":"Gigi Sclipici",
  "amount": 150.75,
  "currency": "RON",
  "paymentMethod": "Test 2"
}
  */

    @PostMapping("/ron")
    public ResponseEntity<String> makeRonPayment(@RequestBody PaymentRequest request) {
      String result = paymentService.makeRonPayment(request);
        return ResponseEntity.ok(result);



    }


}