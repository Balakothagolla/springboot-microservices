package com.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/orderFallback")
	public Mono<String> orderFallback() {
		return Mono.just("Order service is down");
	}
	
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentFallback() {
		return Mono.just("Payment service is down");
	}
}
