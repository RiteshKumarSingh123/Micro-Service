package com.assh.supervisor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Users {
   
    private long   id;
	private String username;
    private String password;
    private String catererId;
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getCatererId() {
		return catererId;
	}
	public void setCatererId(String catererId) {
		this.catererId = catererId;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", catererId=" + catererId
				+ "]";
	}
    
}
