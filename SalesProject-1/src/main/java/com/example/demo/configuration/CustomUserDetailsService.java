package com.example.demo.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JwtDao;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JwtDao jwtDao;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = jwtDao.getUserData(username);
//
//        if (user == null || user.getUsername() == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                user.getCatererId(),
//                Collections.emptyList() // Add authorities if needed
//        );
//    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = jwtDao.getUserData(username);

        if (user == null || user.getUsername() == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getCatererId(),
                Collections.emptyList() // Replace with real roles if needed
        );
    }

}
