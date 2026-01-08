package com.costmih7777.PaymentService.dao;

import com.costmih7777.PaymentService.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can define custom queries here if needed later, e.g.:
    // List<Payment> findByVendorId(Long vendorId);
}
