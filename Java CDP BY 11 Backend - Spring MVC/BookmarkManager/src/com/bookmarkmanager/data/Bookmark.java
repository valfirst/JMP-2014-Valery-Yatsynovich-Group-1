package com.bookmarkmanager.data;

public class Bookmark {

	private Long id;
	private String name;
	private String url;
	
	public Bookmark(){}
	
	public Bookmark(String name, String url){
		this.name = name;
		this.url = url;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
