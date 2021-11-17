package com.microservice.customer.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@Document(collection = "customers")
@Getter
@Setter
public class Customer extends  Person{

    private CustomerType type;

    @Builder
    public Customer(ObjectId _id,String name,String lastName,String dni,CustomerType type) {
        super(_id, name,lastName,dni);
        this.type = type;
    }

}
