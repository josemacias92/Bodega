package com.bodega.demo.winery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineryService {

	@Autowired
	private WineryRepository wineryRepository;
	
	public List<Winery> getAll(){
		return wineryRepository.findAll();
	}
}
