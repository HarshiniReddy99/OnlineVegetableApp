package com.cpg.onlineVegetableApp.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.dao.ICustomerRepository;

import com.cpg.onlineVegetableApp.entities.Customer;
import com.cpg.onlineVegetableApp.exception.CustomerIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.CustomerNotFoundInCityException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository repository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> optional =repository.findById(customer.getCustomerId());
		if (optional.isEmpty()) {
			throw new CustomerIdNotFoundException("Customer with id " + customer.getCustomerId() + " does not Exist");
		}
		repository.delete(optional.get());
		return optional.get();
	
	}

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> optional = repository.findById(customer.getCustomerId());
		if (optional.isEmpty()) {
			throw new CustomerIdNotFoundException("Customer with id " + customer.getCustomerId() + " does not Exist");
		}

		return optional.get();
	}

	@Override
	public List<Customer> viewAllCustomerList(String location) throws CustomerNotFoundInCityException {
		// TODO Auto-generated method stub
		List<Customer> customer=repository.findAllCustomersByLocation(location);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundInCityException("No Customer in this city");
		}
		return(customer);
	}

}
