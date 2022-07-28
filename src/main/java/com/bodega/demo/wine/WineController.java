package com.bodega.demo.wine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.demo.region.Region;
import com.bodega.demo.winery.Winery;

@RestController
@RequestMapping("/api/wines")
public class WineController {

	@Autowired
	WineService wineService;
	
	@GetMapping
	public ResponseEntity<List<Wine>> showAll(){
		List<Wine> list = wineService.getAll();
		
			return  list.size() == 0 
					? ResponseEntity.noContent().build() 
					: ResponseEntity.ok().body(wineService.getAll());
		
	        
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Wine> showOne(@PathVariable int id){
		
		
		Wine item = wineService.getOne(id);
		
		return  item == null 
				? ResponseEntity.notFound().build() 
				: ResponseEntity.ok().body(wineService.getOne(id));
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteOne(@PathVariable int id){
		
		 wineService.deletebyId(id);
		 return ResponseEntity.ok().build();
		 
	}
	@PostMapping
	public ResponseEntity<Wine> save(@RequestBody Wine wine){
		return ResponseEntity.ok().body(wineService.save(wine));
		
		  
	}
	@PutMapping
	public ResponseEntity<Wine> edit(@RequestBody Wine wine){
		return ResponseEntity.ok().body(wineService.save(wine));
		
	}
}
