package com.cpg.onlineVegetableApp.service;

import java.util.List;

import com.cpg.onlineVegetableApp.entities.Feedback;

import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;


public interface IFeedbackService {
	public Feedback addFeedback(Feedback fdk) ;
	public List<Feedback> viewAllFeedbacks(int vegetableId) throws VegetableIdNotFoundException;
}
