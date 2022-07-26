package com.bodega.demo.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	public List<Region> getAll(){
		return regionRepository.findAll();
	}
	
	public Region getOne(int id){
		return regionRepository.findById(id).orElse(null);
	}
}
