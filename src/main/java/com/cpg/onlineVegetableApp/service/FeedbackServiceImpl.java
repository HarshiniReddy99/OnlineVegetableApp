package com.cpg.onlineVegetableApp.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;
import com.cpg.onlineVegetableApp.dao.IFeedbackRepository;

import com.cpg.onlineVegetableApp.entities.Feedback;


@Service
@Transactional
public class FeedbackServiceImpl implements IFeedbackService{
	
	@Autowired
	IFeedbackRepository repository;

	@Override
	public Feedback addFeedback(Feedback fdk)  {
		
		return repository.save(fdk);
			
	}

	@Override
	public List<Feedback> viewAllFeedbacks(int vegetableId) throws VegetableIdNotFoundException {
		List<Feedback> feedback = repository.findFeedback(vegetableId);
		if (feedback.isEmpty()) {
			throw new VegetableIdNotFoundException("Vegetable with id " + vegetableId + " does not Exist");
		}
		return (feedback);
	}
		
		
	}


