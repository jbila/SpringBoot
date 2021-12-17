package com.bila.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String country;
	@Column(name="enabled",nullable = false,columnDefinition = "TINYINT(1)")
	private boolean enabled;
	public Users(int id, String name, String email, String country,boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.enabled=enabled;
	}
	public Users() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
		
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setTEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + ", enabled="
				+ enabled + "]";
	}
	
	

}
