package com.iii.phonservice.model;

public class Message {

	String image;
	String name;
	String content;
	String time;
	
	
	public Message(String image, String name, String content, String time) {
		super();
		this.image = image;
		this.name = name;
		this.content = content;
		this.time = time;
	}
	public Message() {
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
