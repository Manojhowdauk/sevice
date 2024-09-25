package com.service.controller;

import java.util.List;
import java.util.Optional;

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

import com.service.common.exception.RecordNotFoundException;
import com.service.dao.OrderDao;
import com.service.model.Order;
import com.service.mongorepo.OrderMongoRepo;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderMongoRepo orderMongoRepo;
	
	@Autowired
	OrderDao orderDao;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public Order orderCreate(@RequestBody Order order)  
	{
			Order orderDto= orderDao.orderCreate(order);
			return orderDto;
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public Order orderUpdate(@RequestBody Order order) throws RecordNotFoundException
	{
		Optional<Order> orderObj = orderMongoRepo.findById(order.getOrderID());
		if(orderObj.isPresent())
		{
			Order orderDto= orderDao.orderEdit(order);
			return orderDto;
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/get"})
	public Order orderGet(@RequestParam("orderID") String orderID) throws Throwable
	{	
		Optional<Order> orderObj=orderMongoRepo.findById(orderID);
		if(orderObj.isPresent())
		{
			return orderObj.get();
		}
		throw new RecordNotFoundException("Not Exist");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/list"})
	public List<Order> orderList(@RequestParam("companyID") String companyID,@RequestParam("fromDate") long fromDate,@RequestParam("toDate") long toDate,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<Order> orderList= orderMongoRepo.findAllByFromToTime(companyID,fromDate,toDate,PageRequest.of(pageNo, 10));
		return orderList.getContent();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/search/list"})
	public List<Order> orderSearchList(@RequestParam("companyID") String companyID,@RequestParam("search") String search,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<Order> orderList= orderMongoRepo.findAllBySearch(companyID,search,PageRequest.of(pageNo, 10));
		return orderList.getContent();
	}

	@CrossOrigin(origins = "*")
	@GetMapping({"/list/bycustomer"})
	public List<Order> listOfOrderSrachByCustomer(@RequestParam("companyID") String companyID,@RequestParam("customerID") String customerID,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<Order> orderList= orderMongoRepo.findListOfOrderSrachByCustomer(companyID,customerID,PageRequest.of(pageNo, 10));
		return orderList.getContent();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/count/bycustomer"})
	public int orderCountByCustomer(@RequestParam("companyID") String companyID,@RequestParam("customerID") String customerID) throws Throwable
	{	
		return orderMongoRepo.findOrderCountByCustomer(companyID,customerID);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping({"/list/byorderStatus"})
	public List<Order> orderListByorderStatus(@RequestParam("companyID") String companyID,@RequestParam("fromDate") long fromDate,@RequestParam("toDate") long toDate,@RequestParam("orderStatus") String orderStatus,@RequestParam("pageNo") int pageNo) throws Throwable
	{	
		Page<Order> orderList= orderMongoRepo.findOrderListByorderStatus(companyID,fromDate,toDate,orderStatus,PageRequest.of(pageNo, 10));
		return orderList.getContent();
	}
}
