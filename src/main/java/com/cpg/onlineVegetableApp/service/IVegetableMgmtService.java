package com.cpg.onlineVegetableApp.service;

import java.util.List;

import com.cpg.onlineVegetableApp.entities.Vegetable;
import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;


public interface IVegetableMgmtService {
	public Vegetable addVegetable(Vegetable dto);
	public Vegetable updateVegetable(Vegetable dto) ;
	public Vegetable removeVegetable(int vegId) throws VegetableIdNotFoundException ;
	public Vegetable viewVegetable(int vegId)  throws VegetableIdNotFoundException ;
	public List<Vegetable> viewAllVegetables() ;
	public List<Vegetable> viewVegetableList(String category) ;
	public List<Vegetable> viewVegetableByName(String name) ;

}
