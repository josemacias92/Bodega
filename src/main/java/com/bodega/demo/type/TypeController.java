package com.bodega.demo.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/types")
public class TypeController {

	@Autowired
	TypeService typeService;
	@GetMapping
	
	public List<Type> showAll(){
		return typeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Type showOne(@PathVariable int id){
		return typeService.getOne(id);
	}
	
	@PostMapping
	public Type save(@RequestBody Type newType){
		Type type = typeService.save(newType);
		return newType;
	}
	
	@PutMapping
	public Type edit(@RequestBody Type newType){
		Type type = typeService.save(newType);
		return newType;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id){
		typeService.deleteById(id);
	}
}
