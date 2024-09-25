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
import com.service.model.User;
import com.service.mongorepo.UserMongoRepo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserMongoRepo userMongoRepo;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public User userCreate(@RequestBody User user) throws RecordAlreadyExist 
	{
		Optional<User> userObj = userMongoRepo.findById(user.getPhoneNumber());
		if (!userObj.isPresent()) 
		{
			user.setUserID(UUID.randomUUID().toString());	
			user.setCreationTimeDate(System.currentTimeMillis());
			user.setDeleteStatus(false);
			userMongoRepo.save(user);
		   return user;		}
		throw new RecordAlreadyExist("Already Exist");
	}
	 
	
	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public User userUpdate(@RequestBody User user) throws RecordNotFoundException
	{
		Optional<User> userObj = userMongoRepo.findById(user.getPhoneNumber());
		if(userObj.isPresent())
		{
			userObj.get().setUserName(user.getUserName());
			userObj.get().setUserEmailID(user.getUserEmailID());
			userObj.get().setCompanyID(user.getCompanyID());
			userObj.get().setCompanyName(user.getCompanyName());
			userMongoRepo.save(userObj.get());
			return userObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/get"})
	public User userGet(@RequestParam("phoneNumber") String phoneNumber) throws Throwable
	{	
		Optional<User> userObj=userMongoRepo.findById(phoneNumber);
		if(userObj.isPresent())
		{
			return userObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/list"})
	public List<User> userList(@RequestParam("companyID") String companyID,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<User> userList= userMongoRepo.findAllByCompanyID(companyID,PageRequest.of(pageNo, 10));
		return userList.getContent();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping({"/login"})
	public User logIn(@RequestBody User user) throws Throwable
	{			
		Optional<User> userObj=userMongoRepo.findByUserLogIn(user.getCompanyID(),user.getPhoneNumber(),user.getPassWord());
		if(userObj.isPresent())
		{
			return userObj.get();
		}
		throw new RecordNotFoundException("Invalid Login");
	}
	

}
