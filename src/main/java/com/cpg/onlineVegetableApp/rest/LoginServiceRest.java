package com.cpg.onlineVegetableApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.entities.User;
import com.cpg.onlineVegetableApp.exception.UserNotFoundException;
import com.cpg.onlineVegetableApp.service.ILoginService;

@RestController
@RequestMapping("/user")
public class LoginServiceRest {
	
	@Autowired
	ILoginService service;
	
	@PostMapping("/login")
	 public ResponseEntity<User> validateUser(@RequestBody User user) throws UserNotFoundException {
		User user1=service.validateUser(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	 public ResponseEntity<User> logout(@RequestBody User user) throws UserNotFoundException {
		User user1=service.logout(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}

}
