package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.entity.Order;
import com.orderservice.payment.TransactionRequest;
import com.orderservice.payment.TransactionResponse;
import com.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/book")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionRequest) {
		return orderService.saveOrder(transactionRequest);
	}
	
}
