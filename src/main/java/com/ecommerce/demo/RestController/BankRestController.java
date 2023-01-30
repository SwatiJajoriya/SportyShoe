package com.ecommerce.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.DAO.BankDAO;
import com.ecommerce.demo.POJO.BankData;

@RestController
public class BankRestController {
	@Autowired
	BankDAO dao;
	

	@PostMapping("/insertbank")
public BankData insertbank(@RequestBody BankData b) {
		
		return dao.insertbank(b);
	}
}
