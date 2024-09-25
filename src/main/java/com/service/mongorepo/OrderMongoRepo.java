package com.service.mongorepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.model.Order;

@Repository
public interface OrderMongoRepo extends MongoRepository<Order, String>{

	@Query(value="{'companyID':'?0',deleteStatus:false}",sort ="{creationTimeDate:-1}")
	Page<Order> findAllByCompanyID(String companyID, PageRequest of);

	@Query(value="{'companyID':'?0','creationTimeDate' : { $gte: ?1, $lte: ?2 },deleteStatus:false}",sort ="{creationTimeDate:-1}")
	Page<Order> findAllByFromToTime(String companyID, long fromDate, long toDate, PageRequest of);

	@Query(value="{'companyID':'?0','$or':[{'orderID':{$regex : ?1, $options: 'i'}},{'customerPhoneNo':{$regex : ?1, $options: 'i'}},{'customerName':{$regex : ?1, $options: 'i'}},{'vehicleNo':{$regex : ?1, $options: 'i'}} ],deleteStatus:false}",sort ="{creationTimeDate:-1}")
	Page<Order> findAllBySearch(String companyID, String search, PageRequest of);

	@Query(value="{'companyID':'?0','customerID':'?1',deleteStatus:false}",sort ="{creationTimeDate:-1}")
	Page<Order> findListOfOrderSrachByCustomer(String companyID, String customerID, PageRequest of);

	@Query(value="{'companyID':'?0','customerID':'?1',deleteStatus:false}",count = true)
	int findOrderCountByCustomer(String companyID, String customerID);

	@Query(value="{'companyID':'?0','creationTimeDate' : { $gte: ?1, $lte: ?2 },'orderStatus':'?3',deleteStatus:false}",sort ="{creationTimeDate:-1}")
	Page<Order> findOrderListByorderStatus(String companyID, long fromDate, long toDate, String orderStatus,
			PageRequest of);
	

}
