package com.assh.supervisor.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assh.supervisor.dao.JwtDao;
import com.assh.supervisor.model.SupervisorDetails;
import com.assh.supervisor.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JwtDao jwtDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = jwtDao.getUserData(username);

        if (user == null || user.getUsername() == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new SupervisorDetails(
                user.getUsername(),
                user.getPassword(),
                user.getCatererId(),
                Collections.emptyList() // Replace with real roles if needed
        );
    }

}
