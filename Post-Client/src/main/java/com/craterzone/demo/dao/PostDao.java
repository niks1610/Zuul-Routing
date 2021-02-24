package com.craterzone.demo.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "posts")
public class PostDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "post")
	@JsonManagedReference
	private AddressDao address;
	@Column
	private int num_likes;
	@Column
	private int num_views;
	@Column
	private int num_comments;
	public PostDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDao(int id, AddressDao address, int num_likes, int num_views, int num_comments) {
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
	public AddressDao getAddress() {
		return address;
	}
	public void setAddress(AddressDao address) {
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
		return "PostDao [id=" + id + ", address=" + address + ", num_likes=" + num_likes + ", num_views=" + num_views
				+ ", num_comments=" + num_comments + "]";
	}
	
	
}
