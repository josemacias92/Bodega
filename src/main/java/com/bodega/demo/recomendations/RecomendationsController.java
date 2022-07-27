package com.bodega.demo.recomendations;

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
import com.bodega.demo.wine.WineService;

@RestController
@RequestMapping("/api/recommend")
public class RecomendationsController {

	@Autowired
	WineService wineService;

	@GetMapping

	public ResponseEntity<List<Wine>> showAll() {

		List<Wine> list = wineService.getAll();

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Wine> showOne(@PathVariable int id) {

		Wine wine = wineService.getOne(id);

		return wine == null 
				? ResponseEntity.notFound().build() 
				: ResponseEntity.ok().body(wine);
	}

	@PostMapping
	public ResponseEntity<Wine> save(@RequestBody Wine wine) {
		return ResponseEntity.ok().body(wineService.save(wine));
	}

	@PutMapping
	public ResponseEntity<Wine> edit(@RequestBody Wine wine) {
		return ResponseEntity.ok().body(wineService.save(wine));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable int id) {
		wineService.deletebyId(id);
		return ResponseEntity.ok().build();
	}
}
