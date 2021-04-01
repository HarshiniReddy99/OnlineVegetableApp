package com.cpg.onlineVegetableApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.BillingDetails;
@Repository
public interface IBillingDetailsRepository extends JpaRepository<BillingDetails, Integer>{

}
