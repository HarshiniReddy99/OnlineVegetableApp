package com.cpg.onlineVegetableApp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.cpg.onlineVegetableApp.entities.Order;
import com.cpg.onlineVegetableApp.exception.OrderIdNotFoundException;
import com.cpg.onlineVegetableApp.service.IOrderService;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired 
	IOrderService service;
	
	Order order= new Order(1,101,1000,null,"SUCESS",null);
	Order order1= new Order(2,102,500,null,"FAILED",null);
	
	
	@Test
	void addOrderTest() {
		assertNotNull(order.getOrderNo());
		System.out.println(service.addOrder(order));
	}
	
	@Test
	void viewOrderTest() throws OrderIdNotFoundException {
		service.addOrder(order);
		assertEquals("SUCESS",service.viewOrder(order.getOrderNo()).getStatus().toString());}
	
	@Test
	void updateOrderTest()
	{
		assertEquals("SUCESS",service.updateOrderDetails(order).getStatus().toString());
	}

	@Test
	void deleteOrderTest() {
		service.addOrder(order1);
		assertEquals("FAILED",service.updateOrderDetails(order1).getStatus().toString());
	}

	
	
}
