package com.ecommerce.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.demo.DAO.UserDAO;
import com.ecommerce.demo.POJO.UserData;


@RestController
public class UserRestController {

	@Autowired
	UserDAO dao;
	
	
	@PostMapping("/insertuser")
public UserData insertuser(@RequestBody UserData u) {
		
		return dao.insertuser(u);
	}
	
	@PostMapping("/insertalluser")
	public List<UserData> insertall(@RequestBody List<UserData> user){
		return dao.insertalluser(user);
	}
	
	@GetMapping("/getalluser")
	public List<UserData> getall(){
		return dao.getalluser();
	}
	
	@DeleteMapping("deleteuserbyid/{id}")
	public String deletebyid(@PathVariable("id") int id) {
		dao.deleteuserbyid(id);
		return "deleted the id value of "+ id;
	}
	
	@PutMapping("/updateuser")
	public UserData updateByName(@RequestBody UserData user) {
		return dao.updateuser(user);
	}
	
	
	@GetMapping("/getuserbyname/{name}/{id}")
	public String findbyname(@PathVariable("name") String name,@PathVariable("id") int id) throws Exception{
		if(dao.finduserbyname(name, id)!=null) {
			return dao.finduserbyname(name, id);
		}
		else {
			throw new Exception("the name and the id is not found");
		}
	}

}
