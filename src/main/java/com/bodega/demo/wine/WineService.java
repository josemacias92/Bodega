package com.bodega.demo.wine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineService {

	@Autowired
	private WineRepository wineRepository;
	
	public List<Wine> getAll(){
		return wineRepository.findAll();
	}
}
