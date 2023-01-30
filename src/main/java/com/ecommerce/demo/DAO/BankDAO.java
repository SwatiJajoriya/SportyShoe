package com.ecommerce.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.POJO.BankData;

import com.ecommerce.demo.Repo.BankRepo;

@Service
public class BankDAO {
@Autowired
	BankRepo repo;


public BankData insertbank(BankData b) {
	
	return repo.save(b);
	}

public long getBal(String bname) {
	return repo.getBal(bname);
}
}
