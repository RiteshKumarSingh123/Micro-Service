package com.example.demo.model;

public class AuthRequest {

	private String userName;
	private String catererId;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCatererId() {
		return catererId;
	}
	public void setCatererId(String catererId) {
		this.catererId = catererId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AuthRequest [userName=" + userName + ", catererId=" + catererId + ", password=" + password + "]";
	}

	
}
