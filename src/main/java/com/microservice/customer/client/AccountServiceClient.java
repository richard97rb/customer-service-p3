package com.microservice.customer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservice.customer.config.CustomerServiceConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountServiceClient {

	@Autowired
    RestTemplate restTemplate;
	
	@Autowired
	private CustomerServiceConfig config;
	
	
	
}
