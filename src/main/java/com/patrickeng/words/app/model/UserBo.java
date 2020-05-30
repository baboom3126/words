package com.patrickeng.words.app.model;

public class UserBo {
	
	private Long id;
	
	private String name;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("id:" + id + ",");
        sb.append("name:" + name + ",");
        return sb.toString();	}
	
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
