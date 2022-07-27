package com.bodega.demo.winery;

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

import com.bodega.demo.wine.Wine;

@RestController
@RequestMapping("/api/wineries")
public class WineryController {

	@Autowired
	WineryService wineryService;
	@GetMapping
	
	public ResponseEntity<List<Winery>> showAll(){
		List<Winery> list = wineryService.getAll();
		
		return  list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(wineryService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> showOne(@PathVariable int id){

		Winery item = wineryService.getOne(id);
		
		return  item == null 
				? ResponseEntity.notFound().build() 
				: ResponseEntity.ok().body(wineryService.getOne(id));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable int id){
		
		 wineryService.deletebyId(id);
		 return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<Winery> save(@RequestBody Winery winery){
		return ResponseEntity.ok().body(wineryService.save(winery));
	}
	@PutMapping
	public ResponseEntity<Winery> edit(@RequestBody Winery winery){
		return ResponseEntity.ok().body(wineryService.save(winery));
	}
}
