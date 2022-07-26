package com.bodega.demo.winery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bodega.demo.wine.Wine;

@Service
public class WineryService {

	@Autowired
	private WineryRepository wineryRepository;
	
	public List<Winery> getAll(){
		return wineryRepository.findAll();
	}
	

	public Winery getOne(int id){
		return wineryRepository.findById(id).orElse(null);
	}
	
	
	public void deletebyId(int id){
		 wineryRepository.deleteById(id);
	}
	
	

	public Winery save(Winery winery) {
		return wineryRepository.save(winery);
	}
}
