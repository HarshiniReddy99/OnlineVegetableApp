package com.cpg.onlineVegetableApp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cpg.onlineVegetableApp.entities.Address;
import com.cpg.onlineVegetableApp.entities.BillingDetails;
import com.cpg.onlineVegetableApp.exception.BillIdNotFoundException;
import com.cpg.onlineVegetableApp.service.IBillingDetailsService;

@SpringBootTest
public class BillingServiceTest {
	
	@Autowired
	IBillingDetailsService service;
	
	BillingDetails bill= new BillingDetails(1,1,"CASH","20-01-2020","SUCESS",new Address("101","VGN","Avadi","Chennai","Tamil Nadu","600062"));
	BillingDetails bill1= new BillingDetails(2,2,"CASH","20-01-2020","SUCESS",null);
	
	@Test
	void updateBillingDetailsTest() throws BillIdNotFoundException
	{	service.addBill(bill1);
		assertEquals("SUCESS",service.updateBill(bill).getTranactionStatus().toString());
		assertEquals("SUCESS",service.updateBill(bill1).getTranactionStatus().toString());
		
	}
	
	@Test
	void addBillingDetailsTest() {
		
		assertNotNull(bill.getBillingId());
		System.out.println(service.addBill(bill));
	}
	
	@Test
	void viewBillingDetailsTest() throws BillIdNotFoundException
	{
		assertEquals("SUCESS",service.viewBill(bill.getBillingId()).getTranactionStatus().toString());
	}
	
	
}
