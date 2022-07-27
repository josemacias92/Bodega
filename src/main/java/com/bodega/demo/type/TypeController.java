package com.bodega.demo.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<List<Type>> showAll(){
		List<Type> list = typeService.getAll();
		
		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Type> showOne(@PathVariable int id){
		Type item = typeService.getOne(id);
		
		return item == null 
				? ResponseEntity.notFound().build() 
				: ResponseEntity.ok().body(item);
	}
	
	@PostMapping
	public ResponseEntity<Type> save(@RequestBody Type item){
		return ResponseEntity.ok().body(typeService.save(item));
	}
	
	@PutMapping
	public ResponseEntity<Type> edit(@RequestBody Type item){
		return ResponseEntity.ok().body(typeService.save(item));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable int id){
		typeService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
