package com.bodega.demo.recomendations;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.demo.wine.Wine;
import com.bodega.demo.wine.WineService;

@RestController
@RequestMapping("/api/recommend")
public class RecomendationsController {

	@Autowired
	WineService wineService;

	@GetMapping("/best")
	public ResponseEntity<List<Wine>> getBest(@RequestParam(required = false) Integer top) {

		Pageable limit = top == null 
				? null  
				: PageRequest.of(0, top);
		
		List<Wine> list = wineService.getBest(limit);

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}

	@GetMapping("/expensive")
	public ResponseEntity<List<Wine>> getMostExpensive(@RequestParam(required = false) Integer top) {

		Pageable limit = top == null 
				? null  
				: PageRequest.of(0, top);
		
		List<Wine> list = wineService.getMostExpensive(limit);

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/bang")
	public ResponseEntity<List<Wine>> getBestBangForTheBuck(@RequestParam(required = false) Integer top) {

		Pageable limit = top == null 
				? null  
				: PageRequest.of(0, top);
		
		List<Wine> list = wineService.getBestBangForTheBuck(limit);
		
		//List<Wine> resultList = listBest.stream().sorted()

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/vintage")
	public ResponseEntity<HashMap<String, List<Wine>>> getVintage(@RequestParam(required = false) Integer top) {

		Pageable limit = top == null 
				? null  
				: PageRequest.of(0, top);
		
		HashMap<String, List<Wine>> vintageList = wineService.getVintageList(limit);
		
		//List<Wine> resultList = listBest.stream().sorted()

		return vintageList.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(vintageList);
	}
}
