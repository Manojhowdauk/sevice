package com.service.mongorepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.model.Company;

@Repository
public interface CompanyMongoRepo extends MongoRepository<Company, String>{

}
