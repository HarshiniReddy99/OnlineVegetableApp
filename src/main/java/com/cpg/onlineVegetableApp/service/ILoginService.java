package com.cpg.onlineVegetableApp.service;

import com.cpg.onlineVegetableApp.entities.User;
import com.cpg.onlineVegetableApp.exception.UserNotFoundException;


public interface ILoginService {
	 public User validateUser(User user) throws UserNotFoundException;
	 public User logout(User user)throws UserNotFoundException;
}
