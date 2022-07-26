package com.bodega.demo.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;
	
	public List<Type> getAll(){
		return typeRepository.findAll();
	}
}
