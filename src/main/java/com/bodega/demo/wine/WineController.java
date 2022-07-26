package com.bodega.demo.wine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wines")
public class WineController {

	@Autowired
	WineService wineService;
	@GetMapping
	
	public List<Wine> showAll(){
		return wineService.getAll();
	}
}
