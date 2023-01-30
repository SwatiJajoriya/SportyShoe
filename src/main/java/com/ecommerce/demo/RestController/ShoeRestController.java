package com.ecommerce.demo.RestController;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.demo.DAO.ShoeDAO;
import com.ecommerce.demo.POJO.ShoeData;

@RestController
public class ShoeRestController {
	
	@Autowired
	ShoeDAO dao;
	
	@PostMapping("/insert")
public ShoeData insert(@RequestBody ShoeData s) {
		
		return dao.insert(s);
	}
	//insert a list of objects
	@PostMapping("/insertall")
	public List<ShoeData> insertall(@RequestBody List<ShoeData> shoe){
		return dao.insertall(shoe);
	}
	
	@GetMapping("/getall")
	public List<ShoeData> getall(){
		return dao.getall();
	}
	
	@DeleteMapping("deletebyid/{id}")
	public String deletebyid(@PathVariable("id") int id) {
		dao.deletebyid(id);
		return "deleted the id value of "+ id;
	}
	
	@PutMapping("/update")
	public ShoeData updateByName(@RequestBody ShoeData shoe) {
		return dao.updateshoe(shoe);
	}
	
	
	@GetMapping("/getbyname/{name}/{id}")
	public String findbyname(@PathVariable("name") String name,@PathVariable("id") int id) throws Exception{
		if(dao.findbyname(name, id)!=null) {
			return dao.findbyname(name, id);
		}
		else {
			throw new Exception("the name and the id is not found");
		}
	}

}
