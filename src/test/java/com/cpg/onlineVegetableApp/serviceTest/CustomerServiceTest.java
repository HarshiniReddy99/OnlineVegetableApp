package com.cpg.onlineVegetableApp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cpg.onlineVegetableApp.entities.Address;

import com.cpg.onlineVegetableApp.entities.Customer;
import com.cpg.onlineVegetableApp.exception.CustomerIdNotFoundException;
import com.cpg.onlineVegetableApp.service.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	ICustomerService service;
	
	Customer customer2= new Customer(2,"Ankita","9131455705","ankita@gmail.com","XYZ95","XYZ95",new Address("101","VGN","Avadi","Chennai","Tamil Nadu","60062"));
	Customer customer =new Customer(1,"SOUMYA MICHAEL","9836243536", null, null, null, null);
	
	@Test
	void addCustomerTest() throws CustomerIdNotFoundException {
		
		assertNotNull(customer.getCustomerId());
		System.out.println(service.viewCustomer(customer));
	}
	@Test
	void updateCustomerTest()
	{
		assertEquals("SOUMYA MICHAEL",service.updateCustomer(customer).getName().toString());
		
		
	}
	
	@Test
	void viewCustomerTest() throws CustomerIdNotFoundException {
		assertEquals(1,service.viewCustomer(customer).getCustomerId());}
	
	@Test
	void deleteCustomerTest() throws CustomerIdNotFoundException {
		service.addCustomer(customer2);
		Customer customer3= service.removeCustomer(customer2);
		assertEquals(2,customer3.getCustomerId());
	}
	
}
