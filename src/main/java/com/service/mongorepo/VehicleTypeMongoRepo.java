package com.service.mongorepo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.model.VehicleTypeMaster;

@Repository
public interface VehicleTypeMongoRepo extends MongoRepository<VehicleTypeMaster, String>{

	@Query("{'companyID':'?0',deleteStatus:false}")
	Page<VehicleTypeMaster> findAllByCompanyID(String companyID, PageRequest of);

	@Query("{'companyID':'?0','vehicleTypeName':'?1',deleteStatus:false}")
	Optional<VehicleTypeMaster> findByVehicleTypeName(String companyID, String vehicleTypeName);

}
