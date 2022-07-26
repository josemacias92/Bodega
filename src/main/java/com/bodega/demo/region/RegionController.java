package com.bodega.demo.region;

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
@RequestMapping("/regions")
public class RegionController {

	@Autowired
	RegionService regionService;
	@GetMapping
	
	public List<Region> showAll(){
		return regionService.getAll();
	}
	
	@GetMapping("/{id}")
	public Region showOne(@PathVariable int id){
		return regionService.getOne(id);
	}
	
	@PostMapping
	public Region save(@RequestBody Region newRegion){
		Region region = regionService.save(newRegion);
		return newRegion;
	}
	
	@PutMapping
	public Region edit(@RequestBody Region newRegion){
		Region region = regionService.save(newRegion);
		return newRegion;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id){
		regionService.deleteById(id);
	}
}
