package com.cpg.onlineVegetableApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.Vegetable;


@Repository
public interface IVegetableMgmtRepository extends JpaRepository<Vegetable, Integer> {

	List<Vegetable> findAllByCategory(String Category);

	List<Vegetable> findAllByName(String name);
}
