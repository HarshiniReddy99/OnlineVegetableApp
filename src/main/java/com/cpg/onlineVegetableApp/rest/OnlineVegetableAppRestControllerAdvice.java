package com.cpg.onlineVegetableApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cpg.onlineVegetableApp.exception.AdminIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.BillIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.CartIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.CustomerIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.CustomerNotFoundInCityException;
import com.cpg.onlineVegetableApp.exception.OrderIdNotFoundException;
import com.cpg.onlineVegetableApp.exception.UserNotFoundException;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;




@RestControllerAdvice
public class OnlineVegetableAppRestControllerAdvice {
	
		@ExceptionHandler(value = {AdminIdNotFoundException.class})
		public ResponseEntity<String> AdminIdNotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}

		@ExceptionHandler(value = {BillIdNotFoundException.class})
		public ResponseEntity<String> BillIdNotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		

		@ExceptionHandler(value = {CustomerIdNotFoundException.class})
		public ResponseEntity<String> CustomerIdNotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(value = {CustomerNotFoundInCityException.class})
		public ResponseEntity<String> CustomerIdNotFoundInCity(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(value = {VegetableIdNotFoundException.class})
		public ResponseEntity<String> VegetableIdNotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler(value = {UserNotFoundException.class})
		public ResponseEntity<String> UserNotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(value = {OrderIdNotFoundException.class})
		public ResponseEntity<String> FeedbackINotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler(value = {CartIdNotFoundException.class})
		public ResponseEntity<String> CartIdNotFound(Exception exception){
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}

		

	}

	


