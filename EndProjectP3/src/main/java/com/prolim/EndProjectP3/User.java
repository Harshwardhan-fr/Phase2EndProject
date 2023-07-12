package com.prolim.EndProjectP3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	private int uid;
	@Column
	private String name;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
