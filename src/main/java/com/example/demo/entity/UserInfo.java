package com.example.demo.entity;

import java.security.KeyStore.PrivateKeyEntry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserInfo {
	@Id
	private String username;
	private String sex;
	private String telephone;
	
	@JoinColumn(name="username",unique=true)
	@OneToOne
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
