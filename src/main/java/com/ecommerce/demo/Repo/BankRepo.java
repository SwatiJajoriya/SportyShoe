package com.ecommerce.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.demo.POJO.BankData;

public interface BankRepo extends JpaRepository<BankData, Integer>{
@Query("Select b.amount from BankData b where b.bname=?1")
public long getBal(String bname);
}
