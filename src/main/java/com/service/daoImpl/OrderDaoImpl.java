package com.service.daoImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ViewMethodReturnValueHandler;

import com.service.dao.OrderDao;
import com.service.enums.OrderStatusEnum;
import com.service.model.Customer;
import com.service.model.Order;
import com.service.model.Vehicle;
import com.service.mongorepo.CustomerMongoRepo;
import com.service.mongorepo.OrderMongoRepo;
import com.service.mongorepo.VehicleMongoRepo;

@Service
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	OrderMongoRepo orderMongoRepo;
	
	@Autowired
	CustomerMongoRepo customerMongoRepo;
	
	@Autowired
	VehicleMongoRepo vehicleMongoRepo;

	@Override
	public Order orderCreate(Order order) {
		order.setOrderID(UUID.randomUUID().toString());
		order.setCreationTimeDate(System.currentTimeMillis());
		order.setOrderStatus(OrderStatusEnum.PENDING.toString());
		order.setPaymentStatus(false);
		order.setDeleteStatus(false);
		Customer customer=new Customer();
		Optional<Customer> customerObj=customerMongoRepo.findById(order.getCustomerPhoneNo());
		if(!customerObj.isPresent())
		{
		customer.setCustomerID(UUID.randomUUID().toString());
		customer.setCustomerPhoneNo(order.getCustomerPhoneNo());
		customer.setCustomerName(order.getCustomerName());
		customer.setCreationTimeDate(System.currentTimeMillis());
		customer.setDeleteStatus(false);
		customerMongoRepo.save(customer);
		}
		Vehicle vehicle=new Vehicle();
		Optional<Vehicle> vehicleObj=vehicleMongoRepo.findById(order.getVehicleNo());
		if(!vehicleObj.isPresent())
		{
		vehicle.setVehicleID(UUID.randomUUID().toString());
		vehicle.setVehicleNo(order.getVehicleNo());
		vehicle.setVehicleTypeID(order.getVehicleTypeID());
		vehicle.setCreationTimeDate(System.currentTimeMillis());
		vehicle.setDeleteStatus(false);
		vehicleMongoRepo.save(vehicle);
		}
		order.setCustomerID(customerObj.isPresent()?customerObj.get().getCustomerID():customer.getCustomerID());
		order.setVehicleID(vehicleObj.isPresent()?vehicleObj.get().getVehicleID():vehicle.getVehicleID());
		Order orderobj=orderMongoRepo.save(order);
		return orderobj;
	}

	@Override
	public Order orderEdit(Order order)
	{
		Optional<Order> orderObj = orderMongoRepo.findById(order.getOrderID());
		if(orderObj.isPresent())
		{
			orderObj.get().setServiceTypeID(order.getServiceTypeID());
			orderObj.get().setServiceTypeName(order.getServiceTypeName());
			orderObj.get().setAmount(order.getAmount());
			orderObj.get().setPaymentType(order.getPaymentType());
		}	
			return null;
	}

}
