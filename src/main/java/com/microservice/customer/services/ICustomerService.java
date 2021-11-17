package com.microservice.customer.services;

import com.microservice.customer.entities.Signer;
import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.CreateSignerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;

import java.util.List;

public interface ICustomerService {
    ResponseCustomerDto createCustomer(CreateCustomerDto dto) throws Exception;
    List<ResponseCustomerDto> createCustomers(List<CreateCustomerDto> dtos) throws Exception;
    List<ResponseCustomerDto> findCustomersByDni(List<String> dnis) throws  Exception;
    List<ResponseCustomerDto> findCustomersById(List<String> ids) throws  Exception;
    List<Signer> createSigners(List<CreateSignerDto> dtos) throws  Exception;
}
