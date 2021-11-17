package com.microservice.customer.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "signers")
@Getter
@Setter
public class Signer extends Person{

    @Builder
    public Signer(ObjectId _id, String name, String lastName, String dni ) {
        super(_id, name,lastName,dni);
    }

}
