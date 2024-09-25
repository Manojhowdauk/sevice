package com.service.mongorepo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.model.User;

@Repository
public interface UserMongoRepo extends MongoRepository<User, String>{


	@Query("{'companyID':'?0',deleteStatus:false}")
	Page<User> findAllByCompanyID(String companyID, PageRequest of);
	
	@Query("{'companyID':'?0','phoneNumber':'?1','passWord':'?2',deleteStatus:false}")
	Optional<User> findByUserLogIn(String companyID, String phoneNumber, String passWord);

}
