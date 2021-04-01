package com.cpg.onlineVegetableApp.service;

import java.time.LocalDate;
import java.util.List;

import com.cpg.onlineVegetableApp.entities.Order;
import com.cpg.onlineVegetableApp.exception.OrderIdNotFoundException;


public interface IOrderService {
	public Order addOrder(Order order) ;
	public Order viewOrder(int orderNo) throws OrderIdNotFoundException ;
	public Order updateOrderDetails(Order order)  ;
	public List<Order> viewAllOrders(int custid) ;
	public List<Order> viewOrderList(LocalDate date)  ;
	public List<Order> viewOrderList() ;
	public Order cancelOrder(int orderNo) throws OrderIdNotFoundException;

}
