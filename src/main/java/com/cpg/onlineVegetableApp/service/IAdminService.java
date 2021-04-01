package com.cpg.onlineVegetableApp.service;

import com.cpg.onlineVegetableApp.entities.Administrator;
import com.cpg.onlineVegetableApp.exception.AdminIdNotFoundException;


public interface IAdminService {
	public Administrator addAdmin(Administrator admin) ;
	public Administrator updateAdminDetails(Administrator admin) ;
	public Administrator removeAdmin(Administrator admin) throws AdminIdNotFoundException ;
	public Administrator viewAdmin(Administrator admin)throws AdminIdNotFoundException ;

}
