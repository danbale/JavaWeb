package com.softtek.academy.model;

public class UserRole {
	private String description;
	private String userRoleId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		
		this.description = description.trim();
	}

	@Override
	public String toString() {
		return "UserRole [description=" + description + "]";
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	

}
