package com.example.demo.model;

public class Users {

	private String username;
    private String password;
    private String catererId;
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
	public String getCatererId() {
		return catererId;
	}
	public void setCatererId(String catererId) {
		this.catererId = catererId;
	}
	
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", catererId=" + catererId + "]";
	}
    
    
}
