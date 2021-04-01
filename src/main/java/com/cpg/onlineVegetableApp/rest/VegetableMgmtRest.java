package com.cpg.onlineVegetableApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.entities.Vegetable;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;
import com.cpg.onlineVegetableApp.service.IVegetableMgmtService;

@RestController
@RequestMapping("/vegetablemgmt")
public class VegetableMgmtRest {
	
	@Autowired
	private IVegetableMgmtService service;
	
	@PostMapping("/add")
	public Vegetable addVegetable(@RequestBody Vegetable dto){
		return service.addVegetable(dto);
		 
	}
	@PutMapping("/update")
	public Vegetable updateVegetable(@RequestBody Vegetable dto) {
		return service.updateVegetable(dto);
		 
	}
	@DeleteMapping("/remove/{vegId}")
	public Vegetable removeVegetable(@PathVariable("vegId") int vegId) throws VegetableIdNotFoundException {
		return service.removeVegetable(vegId);
		
	}
	@GetMapping("/get/{vegId}")
	public Vegetable viewVegetable(@PathVariable("vegId") int vegId) throws VegetableIdNotFoundException{
		return service. viewVegetable(vegId);
		
		
	}
	@GetMapping("/all")
	public List<Vegetable> viewAllVegetables() {
		List<Vegetable> allveg= service.viewAllVegetables();
		return allveg;
		
	}
	@GetMapping("/allcat/{category}")
	public List<Vegetable> viewVegetableList(@PathVariable("category") String category){
		List<Vegetable> allveg=service.viewVegetableList(category);
		return allveg;
		
	}
	@GetMapping("/allname/{name}")
	public List<Vegetable> viewVegetableByName(@PathVariable("name") String name){
		List<Vegetable> allveg= service.viewVegetableByName(name);
		return allveg;
	}
	
	
	
}
