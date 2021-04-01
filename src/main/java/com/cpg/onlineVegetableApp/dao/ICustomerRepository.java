package com.cpg.onlineVegetableApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value = "select c from Customer c where c.address.area=:Location")
	List<Customer> findAllCustomersByLocation(String Location);
	



}
