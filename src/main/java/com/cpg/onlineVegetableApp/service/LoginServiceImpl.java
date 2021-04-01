package com.cpg.onlineVegetableApp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.dao.ILoginRepository;
import com.cpg.onlineVegetableApp.entities.User;
import com.cpg.onlineVegetableApp.exception.UserNotFoundException;


@Service
@Transactional
public class LoginServiceImpl implements ILoginService{

	@Autowired
	ILoginRepository repository;
	@Override
	public User validateUser(User user) throws UserNotFoundException {
		
		Optional<User> optionalUser=repository.findById(user.getUserId());
		if(!optionalUser.isEmpty())
		{
			if(optionalUser.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	
		
	}

	@Override
	public User logout(User user) throws UserNotFoundException{
		Optional<User> optionalUser=repository.findById(user.getUserId());
		if(!optionalUser.isEmpty())
		{
			if(optionalUser.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

}
