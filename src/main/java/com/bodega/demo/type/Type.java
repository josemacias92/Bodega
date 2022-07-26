package com.bodega.demo.type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {

	@Id()
	@GeneratedValue
	private Integer id;
	private String name;

	public Type(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Type() {

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

}
