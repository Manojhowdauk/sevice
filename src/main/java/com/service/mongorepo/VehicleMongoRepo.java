package com.service.mongorepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.model.Vehicle;

@Repository
public interface VehicleMongoRepo extends MongoRepository<Vehicle, String>{

}
