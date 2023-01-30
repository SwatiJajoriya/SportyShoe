package com.ecommerce.demo.Repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.demo.POJO.ShoeData;



public interface ShoeRepo  extends JpaRepository<ShoeData, Integer> {

	@Query("select s.shoeName from ShoeData s where s.shoeName=?1 and s.shoeId=?2")
	public String findByname(String name,int id);

	//Search query
	@Query("SELECT s from ShoeData s WHERE s.shoeName LIKE %?1%")
	public List<ShoeData> findAll(String Keyword);
	

}
