package com.bodega.demo.wine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WineService {

	@Autowired
	private WineRepository wineRepository;

	public List<Wine> getAll() {
		return wineRepository.findAll();
	}

	public Wine getOne(int id) {
		return wineRepository.findById(id).orElse(null);
	}

	public void deletebyId(int id) {
		wineRepository.deleteById(id);
	}

	public Wine save(Wine wine) {
		return wineRepository.save(wine);
	}

	public List<Wine> getBest(Pageable limit) {
		return wineRepository.findAllOrderByRatingDesc(limit);
	}

	public List<Wine> getMostExpensive(Pageable limit) {
		return wineRepository.findAllOrderByPriceDesc(limit);
	}

	public List<Wine> getBestBangForTheBuck(Pageable limit) {
		return wineRepository.findBestBangForTheBuck(limit);
	}

	public HashMap<String, List<Wine>> getVintageList(Pageable limit) {
		List<String> yearsWithBestRatedWine = wineRepository.findYearsWithBestRatedWines(limit);
		HashMap<String, List<Wine>> topWines = new HashMap<>();

		for (String year : yearsWithBestRatedWine) {
			List<Wine> wines = wineRepository.findByYear(year);
			topWines.put(year, wines);
		}

		return topWines;
	}
}
