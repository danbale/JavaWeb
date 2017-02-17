package com.softtek.academy.model;

public class User {
	
	private String username;
	private String name;
	private  UserRole role;
	private String status;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userName=" + username + ", name=" + name + ", role=" + role + ", status=" + status + "]";
	}
	
	
	
	
}
