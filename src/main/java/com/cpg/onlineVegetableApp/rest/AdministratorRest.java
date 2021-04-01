package com.cpg.onlineVegetableApp.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.exception.AdminIdNotFoundException;
import com.cpg.onlineVegetableApp.entities.Administrator;
import com.cpg.onlineVegetableApp.service.IAdminService;

import io.swagger.annotations.Api;


@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/administrator")
public class AdministratorRest {
	@Autowired
	private IAdminService service;
	
	
	@PostMapping("/add")
	public Administrator addAdmin(@RequestBody Administrator admin) {
		
		return service.addAdmin(admin);
		 
	}
	@PutMapping("/update")
	public Administrator updateAdminDetails(@RequestBody Administrator admin) {
		return service.updateAdminDetails(admin);
		 
	}
	@DeleteMapping("/remove/{adminId}")
	public Administrator removeAdmin(@PathVariable("adminId")Administrator admin)throws AdminIdNotFoundException {
		return service.removeAdmin(admin);
		
	}
	@GetMapping("/get/{adminId}")
	public Administrator viewAdmin(@PathVariable("adminId") Administrator admin) throws AdminIdNotFoundException{
		
		return service.viewAdmin(admin);
		
	}

}
