package com.cpg.onlineVegetableApp.service;

import java.util.List;

import com.cpg.onlineVegetableApp.entities.Customer;
import com.cpg.onlineVegetableApp.exception.CustomerIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.CustomerNotFoundInCityException;



public interface ICustomerService {
	public Customer addCustomer(Customer customer) ;
	public Customer updateCustomer(Customer customer) ;
	public Customer removeCustomer(Customer customer)throws CustomerIdNotFoundException;
	public Customer viewCustomer(Customer customer)throws CustomerIdNotFoundException;
	public List<Customer> viewAllCustomerList(String location)throws CustomerNotFoundInCityException ;

}
