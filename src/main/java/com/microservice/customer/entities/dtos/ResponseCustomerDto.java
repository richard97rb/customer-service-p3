package com.microservice.customer.entities.dtos;

import com.microservice.customer.entities.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomerDto {
    private String _id;

    private String name;

    private String lastName;

    private String dni;

    private CustomerType type;
}
