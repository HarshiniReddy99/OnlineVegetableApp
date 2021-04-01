package com.cpg.onlineVegetableApp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.onlineVegetableApp.dao.IBillingDetailsRepository;

import com.cpg.onlineVegetableApp.entities.BillingDetails;
import com.cpg.onlineVegetableApp.exception.BillIdNotFoundException;

@Service
@Transactional
public class BillingDetailsServiceImpl implements IBillingDetailsService {

	@Autowired
	IBillingDetailsRepository repository;

	@Override
	public BillingDetails addBill(BillingDetails bill) {
		// TODO Auto-generated method stub
		repository.save(bill);
		return bill;
	}

	@Override
	public BillingDetails updateBill(BillingDetails bill) throws BillIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<BillingDetails> optional = repository.findById(bill.getBillingId());
		if (optional.isEmpty()) {
			throw new BillIdNotFoundException("Bill with id " + bill.getBillingId() + " does not Exist");
		}
		repository.save(bill);
		return optional.get();
		
	
	}

	@Override
	public BillingDetails viewBill(int billId) throws BillIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<BillingDetails> optional = repository.findById(billId);
		if (optional.isEmpty()) {
			throw new BillIdNotFoundException("Bill with id " + billId + " does not Exist");
		}
		
		return optional.get();
	}

	
}
