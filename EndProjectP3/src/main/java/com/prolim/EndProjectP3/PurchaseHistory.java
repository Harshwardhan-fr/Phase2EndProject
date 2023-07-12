package com.prolim.EndProjectP3;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class PurchaseHistory {
	@Id
	private int Tid;
	@Column
	private String pname;
	@Column
	private String cname;
	@Column
	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Column
	private Date tDate;
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
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
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public PurchaseHistory(int tid, String pname, String cname, Date tDate) {
		super();
		Tid = tid;
		this.pname = pname;
		this.cname = cname;
		this.tDate = tDate;
	}
	public PurchaseHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
