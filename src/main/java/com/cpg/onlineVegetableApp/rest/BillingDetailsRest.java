package com.cpg.onlineVegetableApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.exception.BillIdNotFoundException;
import com.cpg.onlineVegetableApp.entities.BillingDetails;
import com.cpg.onlineVegetableApp.service.IBillingDetailsService;

import io.swagger.annotations.Api;
@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/billingdetails")
public class BillingDetailsRest{
	
	@Autowired
	private IBillingDetailsService service;
	
	@PostMapping("/add")
	public BillingDetails addBill(@RequestBody BillingDetails bill) {
		return  service.addBill(bill);
		 
		}
	@PutMapping("/update")
	public BillingDetails updateBill(@RequestBody BillingDetails bill)throws BillIdNotFoundException {
		return service.updateBill(bill);
		
	}
	@GetMapping("/get/{billId}")
	public BillingDetails viewBill(@PathVariable("billId")int id) throws BillIdNotFoundException {
		return service.viewBill(id);
		
	}

	
	

}
