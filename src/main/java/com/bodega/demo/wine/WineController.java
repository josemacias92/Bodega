package com.bodega.demo.wine;

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

import com.bodega.demo.region.Region;
import com.bodega.demo.winery.Winery;

@RestController
@RequestMapping("/wines")
public class WineController {

	@Autowired
	WineService wineService;
	
	@GetMapping
	public List<Wine> showAll(){
		return wineService.getAll();
	}
	
	@GetMapping("/{id}")
	public Wine showOne(@PathVariable int id){
		return wineService.getOne(id);
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable int id){
		 wineService.deletebyId(id);
	}
	@PostMapping
	public Wine save(@PathVariable Wine wine){
		 return wineService.save(wine);
	}
	@PutMapping
	public Wine edit(@RequestBody Wine wine){
		 return wineService.save(wine);
	}
}
