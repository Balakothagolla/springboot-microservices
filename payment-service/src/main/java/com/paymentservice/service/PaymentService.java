package com.paymentservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.entity.Payment;
import com.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
    public Payment makePayment(Payment payment) {
    	payment.setTransactionId(UUID.randomUUID().toString());
    	payment.setPaymentStatus("Success");
    	
    	return paymentRepository.save(payment);
    }
	
}
