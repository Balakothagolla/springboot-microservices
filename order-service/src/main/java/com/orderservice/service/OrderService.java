package com.orderservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.entity.Order;
import com.orderservice.payment.Payment;
import com.orderservice.payment.TransactionRequest;
import com.orderservice.payment.TransactionResponse;
import com.orderservice.repository.OrderRepository;

import jakarta.transaction.Transaction;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		Order order =  transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		payment.setAmount(order.getPrice());
		payment.setPaymentDate(new Date());
		
		Order orderResponse = orderRepository.save(order);
		payment.setOrderId(orderResponse.getOrderId());
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/make", payment, Payment.class);
		
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setOrder(orderResponse);
		transactionResponse.setAmount(paymentResponse.getAmount());
		transactionResponse.setTransactionId(paymentResponse.getTransactionId());
		
		return transactionResponse;
	}

}
