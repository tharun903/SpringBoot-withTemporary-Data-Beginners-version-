package com.goodwork.model;

public class BookModel {
	private Integer id;
	private String name;
	private String imageUrl;
	
	public BookModel(Integer id,String name,String imageUrl) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
	}
	
	public BookModel() {}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
