package com.bodega.demo.wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wine {
	@Id()
	@GeneratedValue
	private Integer id;
	private String name;
	private String year;
	private Float rating;
	private Integer num_reviews;
	private Float price;
	private String  body;
	private String  acidity;
	private Integer winery_id;
	private Integer type_id;
	private Integer region_id;
	
	
	
	
	
	
	public Wine(Integer id, String name, String year, Float rating, Integer num_reviews, Float price, String body,
			String acidity, Integer winery_id, Integer type_id, Integer region_id) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.num_reviews = num_reviews;
		this.price = price;
		this.body = body;
		this.acidity = acidity;
		this.winery_id = winery_id;
		this.type_id = type_id;
		this.region_id = region_id;
	}
	public Wine() {
	
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Integer getNum_reviews() {
		return num_reviews;
	}
	public void setNum_reviews(Integer num_reviews) {
		this.num_reviews = num_reviews;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAcidity() {
		return acidity;
	}
	public void setAcidity(String acidity) {
		this.acidity = acidity;
	}
	public Integer getWinery_id() {
		return winery_id;
	}
	public void setWinery_id(Integer winery_id) {
		this.winery_id = winery_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	
	
	
	
	
	
}
