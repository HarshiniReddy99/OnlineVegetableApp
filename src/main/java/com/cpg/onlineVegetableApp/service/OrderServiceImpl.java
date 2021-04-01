package com.cpg.onlineVegetableApp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.dao.IOrderRepository;
import com.cpg.onlineVegetableApp.entities.Order;

import com.cpg.onlineVegetableApp.exception.OrderIdNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository repository;

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return repository.save(order);
	}

	@Override
	public Order viewOrder(int orderNo) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> optional = repository.findById(orderNo);
		if (optional.isEmpty()) {
			throw new OrderIdNotFoundException("Order with id " + orderNo + " does not Exist");
		}

		return optional.get();

	}

	@Override
	public Order updateOrderDetails(Order order) {
		// TODO Auto-generated method stub
		return repository.save(order);
	}

	@Override
	public List<Order> viewAllOrders(int custid) {
		// TODO Auto-generated method stub
		List<Order> allorder = repository.findAllByCustId(custid);
		return allorder;
	}

	@Override
	public List<Order> viewOrderList(LocalDate date) {
		// TODO Auto-generated method stub
		List<Order> allorder = repository.findAllByOrderDate(date);
		return allorder;
	}

	@Override
	public List<Order> viewOrderList() {
		// TODO Auto-generated method stub
		List<Order> allorder = repository.findAll();
		return allorder;
	}

	@Override
	public Order cancelOrder(int orderNo) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> optional = repository.findById(orderNo);
		if (optional.isEmpty()) {
			throw new OrderIdNotFoundException("Order with id " + orderNo + " does not Exist");
		}
		repository.delete(optional.get());
		return optional.get();
	}

}
