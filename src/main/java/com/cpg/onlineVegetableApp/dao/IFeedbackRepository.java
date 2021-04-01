package com.cpg.onlineVegetableApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.Feedback;
@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query("select f from Feedback f where f.vegetableId=:vegetableId")
	List<Feedback> findFeedback(int vegetableId);

}
