package com.cpg.onlineVegetableApp.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.cpg.onlineVegetableApp.entities.Administrator;
import com.cpg.onlineVegetableApp.exception.AdminIdNotFoundException;
import com.cpg.onlineVegetableApp.service.IAdminService;

@SpringBootTest
public class AdminServiceTest {
	
	@Autowired 
	IAdminService service;
	
	Administrator admin= new Administrator(3,"AYUSH BINDROO","982232728","ayu@gmail.com");
	Administrator admin2= new Administrator(4,"SOUMYA","9823223728","som@gmail.com");
	
	@Test
	void updateAdminTest()
	{
		assertEquals("ayu@gmail.com",service.updateAdminDetails(admin).getEmailid().toString());
	}
	
	@Test
	void viewAdminTest() throws AdminIdNotFoundException {
		service.addAdmin(admin);
		assertEquals("AYUSH BINDROO",service.viewAdmin(admin).getName().toString());
		}
	
	@Test
	void addAdminTest() throws AdminIdNotFoundException {
		service.addAdmin(admin);
		assertNotNull(admin.getAdminId());
		System.out.println(service.viewAdmin(admin));
	}
	
	@Test
	void deleteAdminTest() throws AdminIdNotFoundException {
		service.addAdmin(admin2);
		Administrator admin3= service.removeAdmin(admin2);
		assertEquals(4,admin3.getAdminId());
	}


}
