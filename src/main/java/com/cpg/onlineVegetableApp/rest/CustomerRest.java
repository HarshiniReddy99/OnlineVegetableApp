package com.cpg.onlineVegetableApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.entities.Customer;

import com.cpg.onlineVegetableApp.exception.CustomerIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.CustomerNotFoundInCityException;
import com.cpg.onlineVegetableApp.service.ICustomerService;

import io.swagger.annotations.Api;
@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/customer")
public class CustomerRest {
	@Autowired
	private ICustomerService service;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return addCustomer(customer);
		
	}
	@DeleteMapping("/remove/{customerId}")
	public Customer removeCustomer(@PathVariable("customerId") Customer customer)throws CustomerIdNotFoundException {
		return service.removeCustomer(customer);
		
	}
	@GetMapping("/all/{Location}")
	public List<Customer> viewAllCustomerList(@PathVariable("Location") String Location)throws CustomerNotFoundInCityException {
		List<Customer> allcustomers=service.viewAllCustomerList(Location);
		return allcustomers;
	}
	
	@GetMapping("/get/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") Customer customer) throws CustomerIdNotFoundException {
		return service.viewCustomer(customer) ;
		
	}

}


