package com.service.mongorepo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.model.ServiceTypeMaster;

@Repository
public interface ServiceTypeMongoRepo extends MongoRepository<ServiceTypeMaster, String>{

	@Query("{'companyID':'?0',deleteStatus:false}")
	Page<ServiceTypeMaster> findAllByCompanyID(String companyID, PageRequest of);

	@Query("{'companyID':'?0','serviceTypeName':'?1',deleteStatus:false}")
	Optional<ServiceTypeMaster> findByServiceTypeName(String companyID, String serviceTypeName);

}
