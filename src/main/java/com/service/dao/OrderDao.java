package com.service.dao;

import org.springframework.stereotype.Repository;

import com.service.model.Order;

@Repository
public interface OrderDao {

	Order orderCreate(Order order);

	Order orderEdit(Order order);

}
