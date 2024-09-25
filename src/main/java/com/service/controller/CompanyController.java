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
import com.service.model.Company;
import com.service.mongorepo.CompanyMongoRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("company")
@Tag(name = "User API", description = "API for managing users")
public class CompanyController {
	
	@Autowired
	CompanyMongoRepo companyMongoRepo;
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	@Operation(summary = "create user", description = "Returns a users")
    @ApiResponse(responseCode = "200", description = "craete user")
	public Company userCreate(@RequestBody Company company) throws RecordAlreadyExist 
	{
		Optional<Company> companyObj = companyMongoRepo.findById(company.getPhoneNumber());
		if (!companyObj.isPresent()) 
		{
			company.setCompanyID(UUID.randomUUID().toString());	
			company.setTimeDate(System.currentTimeMillis());
			company.setDeleteStatus(false);
			companyMongoRepo.save(company);
		   return company;		}
		throw new RecordAlreadyExist("Already Exist");
	}
	 
	
	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public Company companyUpdate(@RequestBody Company company) throws RecordNotFoundException
	{
		Optional<Company> companyObj = companyMongoRepo.findById(company.getPhoneNumber());
		if(companyObj.isPresent())
		{
			companyObj.get().setCompanyName(company.getCompanyName());
			companyObj.get().setEmailID(company.getEmailID());
			companyObj.get().setContactPerson(company.getContactPerson());
			companyObj.get().setAddress(company.getAddress());
			companyMongoRepo.save(companyObj.get());
			return companyObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/get"})
	public Company companyGet(@RequestParam("phoneNumber") String phoneNumber) throws Throwable
	{	
		Optional<Company> companyObj=companyMongoRepo.findById(phoneNumber);
		if(companyObj.isPresent())
		{
			return companyObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/list"})
	public List<Company> companyList(@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<Company> companyList= companyMongoRepo.findAll(PageRequest.of(pageNo, 10));
		return companyList.getContent();
	}
	
	

}
