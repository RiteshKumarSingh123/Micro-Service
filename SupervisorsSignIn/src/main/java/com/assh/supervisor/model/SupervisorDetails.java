package com.assh.supervisor.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class SupervisorDetails implements UserDetails  {
	private String username;
    private String password;
    private String catererId;
    private Collection<? extends GrantedAuthority> authorities;
	public SupervisorDetails(String username, String password, String catererId,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.catererId = catererId;
		this.authorities = authorities;
	}
    
	 public String getCatererId() {
	        return catererId;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }
	
	
	@Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
    
}
