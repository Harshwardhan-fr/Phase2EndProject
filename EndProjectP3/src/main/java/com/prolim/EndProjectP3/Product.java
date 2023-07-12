package com.prolim.EndProjectP3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	private int Pid;
	@Column
	private String pname;
	@Column
	private String cname;
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Product(int pid, String pname, String cname) {
		super();
		Pid = pid;
		this.pname = pname;
		this.cname = cname;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
