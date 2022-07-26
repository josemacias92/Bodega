package com.bodega.demo.winery;

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

import com.bodega.demo.wine.Wine;

@RestController
@RequestMapping("/wineries")
public class WineryController {

	@Autowired
	WineryService wineryService;
	@GetMapping
	
	public List<Winery> showAll(){
		return wineryService.getAll();
	}
	@GetMapping("/{id}")
	public Winery showOne(@PathVariable int id){
		return wineryService.getOne(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id){
		 wineryService.deletebyId(id);
	}
	
	@PostMapping
	public Winery save(@RequestBody Winery winery){
		 return wineryService.save(winery);
	}
	@PutMapping
	public Winery edit(@RequestBody Winery winery){
		 return wineryService.save(winery);
	}
}
