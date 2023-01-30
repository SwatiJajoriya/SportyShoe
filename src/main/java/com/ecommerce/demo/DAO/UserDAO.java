package com.ecommerce.demo.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.demo.POJO.UserData;
import com.ecommerce.demo.Repo.UserRepo;

@Service
public class UserDAO {
	@Autowired
	UserRepo repo;
	
	
	public UserData insertuser(UserData u) {
		
		return repo.save(u);
		}

	public List<UserData> insertalluser(List<UserData> user){
		return repo.saveAll(user);
		
	}

	public List<UserData> getalluser(){
		return repo.findAll();
	}

	public void deleteuserbyid(int id){
		repo.deleteById(id);
	}

	public UserData updateuser(UserData user) {
		UserData userdata =repo.findById(user.getId()).orElse(null);
		userdata.setName(user.getName());
		userdata.setEmail(user.getEmail());
		userdata.setPhono(user.getPhono());
		userdata.setUsername(user.getUsername());
		userdata.setPassword(user.getPassword());
		return	repo.save(userdata);
		
	}

	public void deleteuser(UserData u) {
		repo.delete(u);

		
	}

	// for search
	public List<UserData> listAlluser(String keyword){
		if(keyword!=null) {
			return repo.findAll(keyword);
		}
		return null;
	}
	
	//service
		//customize query
			public String finduserbyname(String name,int id){
			return repo.findByname(name,id);
		}
			
		
			public UserData findByuserpwd(String username,String password) {
				
				return repo.findByuserpwd(username, password);
			}
	
			public boolean checkEmail(String email) {
				
				return repo.existsByEmail(email);
			}
	
			
			
}
