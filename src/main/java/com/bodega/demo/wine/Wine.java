package com.bodega.demo.wine;

import java.sql.Date;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.tomcat.util.bcel.Const;
import org.hibernate.validator.constraints.Range;



@Entity
public class Wine {
	 final static long ActualYear = (long) Calendar.getInstance().get(Calendar.YEAR);
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	@Range(min = 1900, max = 2022 )
	private String year;
	@NotNull
	@NotEmpty
	@Min(0)
	@Max(5)
	private Float rating;
	@NotNull
	@NotEmpty
	private Integer num_reviews;
	@NotNull
	@NotEmpty
	@Min(0)
	private Float price;
	@NotNull
	@NotEmpty
	@Min(0)
	@Max(5)
	private String  body;
	@NotNull
	@NotEmpty
	private String  acidity;
	@NotNull
	@NotEmpty
	private Integer winery_id;
	@NotNull
	@NotEmpty
	private Integer type_id;
	@NotNull
	@NotEmpty
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
