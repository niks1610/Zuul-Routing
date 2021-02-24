package com.craterzone.demo.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Post {
	
	@Id
	private int id;
	@NotNull
	private Address address;
	private int num_likes;
	private int num_views;
	private int num_comments;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int id, Address address, int num_likes, int num_views, int num_comments) {
		super();
		this.id = id;
		this.address = address;
		this.num_likes = num_likes;
		this.num_views = num_views;
		this.num_comments = num_comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getNum_likes() {
		return num_likes;
	}

	public void setNum_likes(int num_likes) {
		this.num_likes = num_likes;
	}

	public int getNum_views() {
		return num_views;
	}

	public void setNum_views(int num_views) {
		this.num_views = num_views;
	}

	public int getNum_comments() {
		return num_comments;
	}

	public void setNum_comments(int num_comments) {
		this.num_comments = num_comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", num_likes=" + num_likes + ", num_views=" + num_views + ", num_comments="
				+ num_comments + "]";
	}
	
	
	
	

}
