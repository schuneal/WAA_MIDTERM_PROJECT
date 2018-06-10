package edu.mum.coffee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String role;
	
	public User() {
		
	}

	public User(String username, String password, String role) {
		
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(User user) {
		this.username = user.username;
		this.password = user.password;
		this.role = user.role;
	}

	public int getId() {
		return id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
