package com.cpg.onlineVegetableApp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.dao.IVegetableMgmtRepository;
import com.cpg.onlineVegetableApp.entities.Vegetable;

import com.cpg.onlineVegetableApp.exception.VegetableIdNotFoundException;

@Service
@Transactional
public class VegetableMgmtService implements IVegetableMgmtService {

	@Autowired
	IVegetableMgmtRepository repository;

	@Override
	public Vegetable addVegetable(Vegetable dto) {
		// TODO Auto-generated method stub
		return  repository.save(dto);
		
	}

	@Override
	public Vegetable updateVegetable(Vegetable dto) {
		// TODO Auto-generated method stub
		return  repository.save(dto);
	}

	@Override
	public Vegetable removeVegetable(int vegId) throws VegetableIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Vegetable> optional = repository.findById(vegId);
		if (optional.isEmpty()) {
			throw new VegetableIdNotFoundException("Vegetable with id " + vegId + " does not Exist");
		}
		repository.delete(optional.get());
		return optional.get();
	}

	@Override
	public Vegetable viewVegetable(int vegId) throws VegetableIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Vegetable> optional = repository.findById(vegId);
		if (optional.isEmpty()) {
			throw new VegetableIdNotFoundException("Vegetable with id " + vegId + " does not Exist");
		}
		
		return optional.get();
	}

	@Override
	public List<Vegetable> viewAllVegetables() {
		// TODO Auto-generated method stub
		List<Vegetable> vegetablelist=repository.findAll();
		return vegetablelist;
	}

	@Override
	public List<Vegetable> viewVegetableList(String category) {
		// TODO Auto-generated method stub
		List<Vegetable> vegetablelist=repository.findAllByCategory(category);
		return  vegetablelist;
	}

	@Override
	public List<Vegetable> viewVegetableByName(String name) {
		// TODO Auto-generated method stub
		List<Vegetable> vegetablelist=repository.findAllByName(name);
		return vegetablelist;
	}

}
