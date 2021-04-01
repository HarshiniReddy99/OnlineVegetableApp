package com.cpg.onlineVegetableApp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cpg.onlineVegetableApp.entities.Vegetable;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;
import com.cpg.onlineVegetableApp.service.IVegetableMgmtService;

@SpringBootTest
public class VegetableServiceTest {
	
	@Autowired 
	IVegetableMgmtService service;
	
	Vegetable veg= new Vegetable(10,"ORANGE","NON-LEAFY","FRUIT",70,1);
	Vegetable veg1= new Vegetable(20,"LADYFINGER","NON-LEAFY","VEGETABLE",50.0,1);
	Vegetable veg2= new Vegetable(30,"TOMATO","NON-LEAFY","VEGETABLE",20.0,1);
	
	@Test
	void addVegetableTest() {
		assertNotNull(veg.getVegId());
		System.out.println(service.addVegetable(veg));
	}
	
	@Test
	void updateVegetableTest()
	{
		assertEquals("ORANGE",service.updateVegetable(veg).getName().toString());
	}
	
	@Test
	void deleteVegetableTest() throws VegetableIdNotFoundException {
		service.addVegetable(veg1);
		Vegetable veg4= service.removeVegetable(veg1.getVegId());
		assertEquals(20,veg4.getVegId());
	}
		
	@Test
	void viewVegetableTest() throws VegetableIdNotFoundException {
		assertEquals("NON-LEAFY",service.viewVegetable(veg.getVegId()).getType().toString());}
	
	
}


