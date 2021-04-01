package com.cpg.onlineVegetableApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.Cart;
@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{
	


}
