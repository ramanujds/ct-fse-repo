package com.ct.springboot.example.model;

public class Message {
	private String title;
	private String category;
	private String details;
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Message(String title, String category, String details) {
		super();
		this.title = title;
		this.category = category;
		this.details = details;
	}
	
	
}
