package com.bodega.demo.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	public List<Type> getAll(){
		return typeRepository.findAll();
	}

	public Type getOne(int id){
		return typeRepository.findById(id).orElse(null);
	}
	
	public Type save(Type newType){
		Type type = typeRepository.save(newType);
		return type;
	}
	
	public void deleteById(int id){
		typeRepository.deleteById(id);
	}
}