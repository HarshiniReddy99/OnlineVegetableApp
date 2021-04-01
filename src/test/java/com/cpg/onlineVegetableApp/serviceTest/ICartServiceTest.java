package com.cpg.onlineVegetableApp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cpg.onlineVegetableApp.entities.Cart;
import com.cpg.onlineVegetableApp.exception.CartIdNotFoundException;
import com.cpg.onlineVegetableApp.service.ICartService;

@SpringBootTest
public class ICartServiceTest {
	
	@Autowired 
	ICartService service;
	
	Cart cart= new Cart(10,10,null);
	Cart cart1= new Cart(101,11,null);
	
	@Test
	void addCartTest() {
		
		assertNotNull(cart.getCartId());
		
	}
	@Test
	void viewCartTest() {
		
		assertEquals(10,service.viewCart(cart).getCartId());
		}
	
	@Test
	void  removeAllItemsTest() throws CartIdNotFoundException  {
		service.addCart(cart1);
		Cart cart3= service.removeAllItems(cart1.getCartId());
		assertEquals(101,cart3.getCartId());
	}
}
