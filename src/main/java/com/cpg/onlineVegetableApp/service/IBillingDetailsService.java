package com.cpg.onlineVegetableApp.service;

import com.cpg.onlineVegetableApp.entities.BillingDetails;
import com.cpg.onlineVegetableApp.exception.BillIdNotFoundException;



public interface IBillingDetailsService {
	public BillingDetails addBill(BillingDetails bill) ;
	public BillingDetails updateBill(BillingDetails bill)throws BillIdNotFoundException ;
	public BillingDetails viewBill(int billId)throws BillIdNotFoundException ;

}
