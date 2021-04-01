package com.cpg.onlineVegetableApp.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.entities.Order;
import com.cpg.onlineVegetableApp.exception.OrderIdNotFoundException;
import com.cpg.onlineVegetableApp.service.IOrderService;



@RestController
@RequestMapping("/order")
public class OrderRest {
	
	@Autowired
	private IOrderService service;
	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		return service.addOrder(order);
		
	}
	@GetMapping("/get/{orderNo}")
	public Order viewOrder(@PathVariable int orderNo) throws OrderIdNotFoundException{
		return service.viewOrder(orderNo);
		
	}
	@GetMapping("/getAllOrder/{custid}")
	public List<Order> viewAllOrders(@PathVariable int custid){
		return service.viewAllOrders(custid);
			
	}
	@GetMapping("/getOrderList")
	public List<Order> viewOrderList(){
		return service.viewOrderList();
		 
	}
	@PutMapping("/update")
	public Order updateOrderDetails(@RequestBody Order order) {
		return service.updateOrderDetails(order);
	
	}
	@GetMapping("/getOrderListByDate/{date}")
	public List<Order> viewOrderList(@PathVariable("date") LocalDate date){
		List<Order> allOrders= service.viewOrderList(date);
		return allOrders;
		
		 
	}
	@DeleteMapping("/delete/{orderNo}")
	public Order cancelOrder(@PathVariable int orderNo) throws OrderIdNotFoundException{
		return service.cancelOrder(orderNo);
		
	}
	


}
