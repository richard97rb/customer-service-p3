package com.microservice.customer.repositories;

import com.microservice.customer.entities.Signer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignerRepository extends MongoRepository<Signer, ObjectId> {
}
