package com.cpg.onlineVegetableApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;
import com.cpg.onlineVegetableApp.entities.Feedback;
import com.cpg.onlineVegetableApp.service.IFeedbackService;

@RestController
@RequestMapping("/feedback")
//Class Level Comment
/************************************************************************************
*          @author          Ankita
*          Description      It is a Controller class that provides the Handler 
*          methods for adding new feedback, 
                                       
*         Version             1.0
*         Created Date    	22-March-2021
************************************************************************************/

public class FeedbackRest {
	@Autowired
	private IFeedbackService service;
	
	
	@PostMapping("/add")
	public Feedback addFeedback(@RequestBody Feedback fdk) {
		return service.addFeedback(fdk);
		
	}
	@GetMapping("/all/{vegetableId}")
	public List<Feedback> viewAllFeedbacks(@PathVariable("vegetableId")int vegetableId) throws VegetableIdNotFoundException{
		List<Feedback> allFeedback=service. viewAllFeedbacks(vegetableId);
		return allFeedback;
	}

}
