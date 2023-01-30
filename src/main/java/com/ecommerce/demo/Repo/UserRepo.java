package com.ecommerce.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.demo.POJO.UserData;

public interface UserRepo extends JpaRepository<UserData, Integer> {
	
	

	
	@Query("select u from UserData u where u.username=?1 and u.password=?2")
	public UserData findByuserpwd(String username,String password);

	@Query("select u.name from UserData u where u.name=?1 and u.id=?2")
	public String findByname(String name,int id);

	//Search query
		@Query("SELECT u from UserData u WHERE u.name LIKE %?1%"
				     +"OR u.email LIKE %?1%")
		public List<UserData> findAll(String Keyword);
		
		
	//query to check email
		public boolean existsByEmail(String email);
		
	
		
		
}
