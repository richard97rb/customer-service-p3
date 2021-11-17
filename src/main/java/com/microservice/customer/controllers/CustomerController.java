package com.microservice.customer.controllers;

import com.microservice.customer.entities.Signer;
import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.CreateSignerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;
import com.microservice.customer.services.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @PostMapping()
    public Mono<ResponseCustomerDto> createCustomer(@Validated @RequestBody CreateCustomerDto dto) throws  Exception{
        return Mono.just(customerService.createCustomer(dto));
    }

    @PostMapping("/createCustomers")
    public Flux<ResponseCustomerDto> createCustomers(@Validated @RequestBody List<CreateCustomerDto> dtos) throws  Exception{
        return Mono.just(customerService.createCustomers(dtos)).flatMapMany(Flux::fromIterable);
    }

    @PostMapping("/createSigners")
    public Flux<Signer> createSigners(@Validated @RequestBody List<CreateSignerDto> dtos) throws  Exception{
        return Mono.just(customerService.createSigners(dtos)).flatMapMany(Flux::fromIterable);
    }

    @PostMapping("/findCustomers")
    public Flux<ResponseCustomerDto> getCustomerByDni(@Validated @RequestBody List<String> dnis) throws Exception{
    	return Flux.fromIterable(customerService.findCustomersByDni(dnis));
    }
    
    @PostMapping("/findCustomersById")
    public Flux<ResponseCustomerDto> getCustomerByIds(@Validated @RequestBody List<String> ids) throws Exception{
    	return Flux.fromIterable(customerService.findCustomersById(ids));
    }


}
