package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coach {
	@Id
	private String coachid;
	private String coachname;
	public String getCoachid() {
		return coachid;
	}
	public void setCoachid(String coachid) {
		this.coachid = coachid;
	}
	public String getCoachname() {
		return coachname;
	}
	public void setCoachaname(String coachaname) {
		this.coachname = coachaname;
	}

	
}
