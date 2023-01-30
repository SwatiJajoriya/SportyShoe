package com.ecommerce.demo.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.demo.POJO.ShoeData;
import com.ecommerce.demo.Repo.ShoeRepo;

@Service
public class ShoeDAO {
	
	@Autowired
	ShoeRepo repo;
	
public ShoeData insert(ShoeData s) {
		
	return repo.save(s);
	}

public List<ShoeData> insertall(List<ShoeData> shoe){
	return repo.saveAll(shoe);
	
}

public List<ShoeData> getall(){
	return repo.findAll();
}

public void deletebyid(int id){
	repo.deleteById(id);
}

public ShoeData updateshoe(ShoeData shoe) {
	ShoeData shoedata =repo.findById(shoe.getShoeId()).orElse(null);
	shoedata.setShoeName(shoe.getShoeName());
	shoedata.setShoePrice(shoe.getShoePrice());
	return	repo.save(shoedata);
	
}

public void delete(ShoeData s) {
	repo.delete(s);

	
}

// for search
public List<ShoeData> listAll(String keyword){
	if(keyword!=null) {
		return repo.findAll(keyword);
	}
	return null;
}
//service
	//customize query
		public String findbyname(String name,int id){
		return repo.findByname(name,id);
	}
		
	

}

