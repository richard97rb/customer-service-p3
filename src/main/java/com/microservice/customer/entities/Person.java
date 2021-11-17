package com.microservice.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Person {
    @Id()
    private final ObjectId _id;

    @NotEmpty
    private final String name;

    @Field("last_name")
    @NotEmpty
    private final String lastName;

    @NotEmpty
    private final String dni;

}
