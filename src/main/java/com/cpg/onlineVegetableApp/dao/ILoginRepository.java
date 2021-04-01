package com.cpg.onlineVegetableApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpg.onlineVegetableApp.entities.User;


@Repository
public interface ILoginRepository extends JpaRepository<User,String>  {

}
