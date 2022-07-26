package com.bodega.demo.winery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class WineryService {

	@Autowired
	private WineryRepository wineryRepository;
	
	public List<Winery> getAll(){
		return wineryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Winery getOne(int id){
		return wineryRepository.findById(id).orElse(null);
	}
}
