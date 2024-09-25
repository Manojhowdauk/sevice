package com.service.mongorepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.model.Customer;

@Repository
public interface CustomerMongoRepo extends MongoRepository<Customer, String>{

}
