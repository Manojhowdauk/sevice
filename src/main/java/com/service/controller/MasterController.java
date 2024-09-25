package com.service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.common.exception.RecordAlreadyExist;
import com.service.common.exception.RecordNotFoundException;
import com.service.model.ServiceTypeMaster;
import com.service.model.VehicleTypeMaster;
import com.service.mongorepo.ServiceTypeMongoRepo;
import com.service.mongorepo.VehicleTypeMongoRepo;

@RestController
@RequestMapping("master")
public class MasterController {
	
	

	@Autowired
	ServiceTypeMongoRepo serviceTypeMongoRepo;
	
	@Autowired
	VehicleTypeMongoRepo vehicleTypeMongoRepo;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/serviceType/create")
	public ServiceTypeMaster srviceTypeMaterCreate(@RequestBody ServiceTypeMaster serviceTypeMaster) throws RecordAlreadyExist 
	{
		Optional<ServiceTypeMaster> serviceTypeMasterObj = serviceTypeMongoRepo.findByServiceTypeName(serviceTypeMaster.getCompanyID(),serviceTypeMaster.getServiceTypeName());
		if (!serviceTypeMasterObj.isPresent()) 
		{
			serviceTypeMaster.setServiceTypeID(UUID.randomUUID().toString());	
			serviceTypeMaster.setCreationTimeDate(System.currentTimeMillis());
			serviceTypeMaster.setDeleteStatus(false);
			serviceTypeMongoRepo.save(serviceTypeMaster);
		   return serviceTypeMaster;		}
		throw new RecordAlreadyExist("Already Exist");
	}
	 
	
	@CrossOrigin(origins = "*")
	@PutMapping("/serviceType/update")
	public ServiceTypeMaster serviceTypeMaterUpdate(@RequestBody ServiceTypeMaster serviceTypeMaster) throws RecordNotFoundException
	{
		Optional<ServiceTypeMaster> serviceTypeMasterObj = serviceTypeMongoRepo.findById(serviceTypeMaster.getServiceTypeID());
		if(serviceTypeMasterObj.isPresent())
		{
			serviceTypeMasterObj.get().setServiceTypeName(serviceTypeMaster.getServiceTypeName());
			serviceTypeMasterObj.get().setCompanyID(serviceTypeMaster.getCompanyID());
			serviceTypeMasterObj.get().setCompanyName(serviceTypeMaster.getCompanyName());
			serviceTypeMongoRepo.save(serviceTypeMasterObj.get());
			return serviceTypeMasterObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/serviceType/get"})
	public ServiceTypeMaster serviceTypeMaterGet(@RequestParam("serviceTypeID") String serviceTypeID) throws Throwable
	{	
		Optional<ServiceTypeMaster>serviceTypeMaterObj=serviceTypeMongoRepo.findById(serviceTypeID);
		if(serviceTypeMaterObj.isPresent())
		{
			return serviceTypeMaterObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/serviceType/list"})
	public List<ServiceTypeMaster> serviceTypeMaterList(@RequestParam("companyID") String companyID,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<ServiceTypeMaster> ServiceTypeMaterList= serviceTypeMongoRepo.findAllByCompanyID(companyID,PageRequest.of(pageNo, 10));
		return ServiceTypeMaterList.getContent();
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/vehicleType/create")
	public VehicleTypeMaster vehicleTypeMasterCreate(@RequestBody VehicleTypeMaster vehicleTypeMaster) throws RecordAlreadyExist 
	{
		Optional<VehicleTypeMaster> vehicleTypeMasterObj = vehicleTypeMongoRepo.findByVehicleTypeName(vehicleTypeMaster.getCompanyID(),vehicleTypeMaster.getVehicleTypeName());
		if (!vehicleTypeMasterObj.isPresent()) 
		{
			vehicleTypeMaster.setVehicleTypeID(UUID.randomUUID().toString());	
			vehicleTypeMaster.setCreationTimeDate(System.currentTimeMillis());
			vehicleTypeMaster.setDeleteStatus(false);
			vehicleTypeMongoRepo.save(vehicleTypeMaster);
		   return vehicleTypeMaster;		}
		throw new RecordAlreadyExist("Already Exist");
	}
	 
	
	@CrossOrigin(origins = "*")
	@PutMapping("/vehicleType/update")
	public VehicleTypeMaster vehicleTypeMasterUpdate(@RequestBody VehicleTypeMaster vehicleTypeMaster) throws RecordNotFoundException
	{
		Optional<VehicleTypeMaster> VehicleTypeMasterObj = vehicleTypeMongoRepo.findById(vehicleTypeMaster.getVehicleTypeID());
		if(VehicleTypeMasterObj.isPresent())
		{
			VehicleTypeMasterObj.get().setVehicleTypeName(vehicleTypeMaster.getVehicleTypeName());
			VehicleTypeMasterObj.get().setCompanyID(vehicleTypeMaster.getCompanyID());
			VehicleTypeMasterObj.get().setCompanyName(vehicleTypeMaster.getCompanyName());			
			vehicleTypeMongoRepo.save(VehicleTypeMasterObj.get());
			return VehicleTypeMasterObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/vehicleType/get"})
	public VehicleTypeMaster vehicleTypeMasterGet(@RequestParam("vehicleTypeID") String vehicleTypeID) throws Throwable
	{	
		Optional<VehicleTypeMaster> vehicleTypeMasterObj=vehicleTypeMongoRepo.findById(vehicleTypeID);
		if(vehicleTypeMasterObj.isPresent())
		{
			return vehicleTypeMasterObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/vehicleType/list"})
	public List<VehicleTypeMaster> vehicleTypeMasterList(@RequestParam("companyID") String companyID,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<VehicleTypeMaster> vehicleTypeMasterList= vehicleTypeMongoRepo.findAllByCompanyID(companyID,PageRequest.of(pageNo, 10));
		return vehicleTypeMasterList.getContent();
	}


}
