package com.microservice.customer.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.microservice.customer.entities.Signer;
import com.microservice.customer.entities.dtos.CreateCustomerDto;
import com.microservice.customer.entities.dtos.CreateSignerDto;
import com.microservice.customer.entities.dtos.ResponseCustomerDto;
import com.microservice.customer.services.ICustomerService;

@ExtendWith(SpringExtension.class)
@WebFluxTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	private ICustomerService customerService;
	
	public static final ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void createCustomerTest() throws Exception {
		
		CreateCustomerDto customer = CreateCustomerDto.builder()
										.name("Christian")
										.lastName("Garcia")
										.dni("72468245")
										.build();
		
		ResponseCustomerDto customerResponse = modelMapper.map(customer,ResponseCustomerDto.class);
		customerResponse.set_id(new ObjectId().toString());
		
		when(customerService.createCustomer(customer)).thenReturn(customerResponse);
		
		webTestClient.post()
			.uri("/api/customers/")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.bodyValue(customer)
			.exchange()
			.expectStatus().isOk()
			.expectBody(ResponseCustomerDto.class);
		
	}
	
	@Test
	public void createCustomersTest() throws Exception {
		
		List<CreateCustomerDto> customers = Arrays.asList(CreateCustomerDto.builder()
										.name("Christian")
										.lastName("Garcia")
										.dni("72468245")
										.build());
		
		List<ResponseCustomerDto> customerResponse = new ArrayList<>();
		customers.forEach(customer -> {
			ResponseCustomerDto res = modelMapper.map(customer,ResponseCustomerDto.class);
			res.set_id(new ObjectId().toString());
			customerResponse.add(res);
		});
		
		when(customerService.createCustomers(customers)).thenReturn(customerResponse);
		
		webTestClient.post()
			.uri("/api/customers/createCustomers")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.bodyValue(customers)
			.exchange()
			.expectStatus().isOk()
			.expectBodyList(ResponseCustomerDto.class);
		
	}
	
//	@Test
//	public void createSignersTest() throws Exception {
//		
//		List<CreateSignerDto> signers = Arrays.asList(CreateSignerDto.builder()
//										.name("Maria")
//										.lastName("Martinez")
//										.dni("07286109")
//										.build());
//		
//		List<Signer> signerResponse = new ArrayList<>();
//		signers.forEach(signer -> {
//			Signer res = modelMapper.map(signer, Signer.class);
//			signerResponse.add(res);
//		});
//		
//		when(customerService.createSigners(signers)).thenReturn(signerResponse);
//		
//		webTestClient.post()
//			.uri("/api/customers/createSigners")
//			.contentType(MediaType.APPLICATION_JSON)
//			.accept(MediaType.APPLICATION_JSON)
//			.bodyValue(signers)
//			.exchange()
//			.expectStatus().isOk()
//			.expectBodyList(Signer.class);
//		
//	}
	
	@Test
	public void getCustomerByDniTest() throws Exception {
		
		List<String> dnis = new ArrayList<>();
		dnis.add("22222222");
		
		ResponseCustomerDto customer = ResponseCustomerDto.builder()
				._id(new ObjectId().toString())
				.name("Christian")
				.lastName("Garcia")
				.dni("22222222")
				.build();
		
		List<ResponseCustomerDto> response = new ArrayList<>();
		response.add(customer);
		
		when(customerService.findCustomersByDni(dnis)).thenReturn(response);
		
		webTestClient.post()
			.uri("/api/customers/findCustomers")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.bodyValue(dnis)
			.exchange()
			.expectStatus().isOk()
			.expectBodyList(ResponseCustomerDto.class);
		
	}
	
	public void getCustomerByIds() throws Exception {
		
		ObjectId id = new ObjectId();
		List<String> ids = Arrays.asList(id.toString());
		
		ResponseCustomerDto customer = ResponseCustomerDto.builder()
				._id(id.toString())
				.name("Christian")
				.lastName("Garcia")
				.dni("22222222")
				.build();
		
		List<ResponseCustomerDto> response = new ArrayList<>();
		response.add(customer);
		
		when(customerService.findCustomersById(ids)).thenReturn(response);
		
		webTestClient.post()
			.uri("/api/customers/findCustomersById")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.bodyValue(ids)
			.exchange()
			.expectStatus().isOk()
			.expectBodyList(ResponseCustomerDto.class);
		
	}
	
	
}
