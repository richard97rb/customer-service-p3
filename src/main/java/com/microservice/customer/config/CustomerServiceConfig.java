package com.microservice.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource({"classpath:application.properties"})
public class CustomerServiceConfig {

	@Value("${accountservice.url}")
    private String accountServiceUrl;
	
}
