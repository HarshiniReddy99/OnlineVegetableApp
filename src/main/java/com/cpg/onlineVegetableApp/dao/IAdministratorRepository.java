package com.cpg.onlineVegetableApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.Administrator;


@Repository
public interface IAdministratorRepository  extends JpaRepository<Administrator, Integer> {

}
