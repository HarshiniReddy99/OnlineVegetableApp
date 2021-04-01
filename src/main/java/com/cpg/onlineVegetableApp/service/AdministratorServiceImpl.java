package com.cpg.onlineVegetableApp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.dao.IAdministratorRepository;
import com.cpg.onlineVegetableApp.entities.Administrator;
import com.cpg.onlineVegetableApp.exception.AdminIdNotFoundException;

@Service
@Transactional
public class AdministratorServiceImpl implements IAdminService {

	@Autowired
	IAdministratorRepository repository;

	@Override
	public Administrator addAdmin(Administrator admin) {
		// TODO Auto-generated method stub
		return repository.save(admin);
	}

	@Override
	public Administrator updateAdminDetails(Administrator admin) {
		// TODO Auto-generated method stub
		return repository.save(admin);
	}

	@Override
	public Administrator removeAdmin(Administrator admin) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> optional = repository.findById(admin.getAdminId());
		if (optional.isEmpty()) {
			throw new AdminIdNotFoundException("Admin with id " + admin.getAdminId() + " does not Exist");
		}
		repository.delete(optional.get());
		return optional.get();
	}
	

	@Override
	public Administrator viewAdmin(Administrator admin) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> optional = repository.findById(admin.getAdminId());
		if (optional.isEmpty()) {
			throw new AdminIdNotFoundException("Administrator with id " +admin.getAdminId()+ " does not Exist");
		}

		return optional.get();
	}

	

}
