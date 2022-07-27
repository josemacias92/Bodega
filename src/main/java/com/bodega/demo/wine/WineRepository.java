package com.bodega.demo.wine;

import java.util.List;

import org.springframework.data.domain.Pageable;import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {
	
	@Query("select w from Wine w order by rating desc")
	List<Wine> findAllOrderByRatingDesc(Pageable pageable);
	
	@Query("select w from Wine w order by price desc")
	List<Wine> findAllOrderByPriceDesc(Pageable pageable);
	
	@Query("select w from Wine w order by w.rating/w.price desc")
	List<Wine> findBestBangForTheBuck(Pageable pageable);
	
	@Query("select distinct w.year from Wine w order by rating desc")
	List<String> findYearsWithBestRatedWines(Pageable pageable);
	
	List<Wine> findByYear(String year);
}
