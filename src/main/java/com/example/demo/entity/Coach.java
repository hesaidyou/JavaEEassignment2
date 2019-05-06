package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coach {
	@Id
	private String coachid;
	private String coachaname;
	public String getCoachid() {
		return coachid;
	}
	public void setCoachid(String coachid) {
		this.coachid = coachid;
	}
	public String getCoachaname() {
		return coachaname;
	}
	public void setCoachaname(String coachaname) {
		this.coachaname = coachaname;
	}

	
}
