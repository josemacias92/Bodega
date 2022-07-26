package com.bodega.demo.wine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.demo.region.Region;

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
}
