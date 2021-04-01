package com.cpg.onlineVegetableApp.serviceTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cpg.onlineVegetableApp.entities.Feedback;
import com.cpg.onlineVegetableApp.service.IFeedbackService;

@SpringBootTest
public class FeedbackServiceTest {

	@Autowired 
	IFeedbackService service;
	Feedback feedback= new Feedback(1,1,1,3,"FRESH");
	@Test
	void addFeedbackTest() {
		assertNotNull(feedback.getFeedbackId());
		System.out.println(service.addFeedback(feedback));
	}
}
