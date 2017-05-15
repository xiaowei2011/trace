package com.trace.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String origin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date plantDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pickDate;
	
	private String img;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPlantDate() {
		return plantDate;
	}
	public void setPlantDate(Date plantDate) {
		this.plantDate = plantDate;
	}
	public Date getPickDate() {
		return pickDate;
	}
	public void setPickDate(Date pickDate) {
		this.pickDate = pickDate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", origin=" + origin
				+ ", plantDate=" + plantDate + ", pickDate=" + pickDate + ", img=" + img + "]";
	}
}
