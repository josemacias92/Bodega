package com.bodega.demo.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	public List<Type> getAll(){
		return typeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Type getOne(int id){
		return typeRepository.findById(id).orElse(null);
	}
}
