package com.bodega.demo.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	public Region showOne(@PathVariable int id){
		return regionService.getOne(id);
	}
}
