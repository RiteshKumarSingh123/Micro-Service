package com.example.demo.configuration;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.dao.JwtDao;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//	@Component
//	public class JwtFilter extends OncePerRequestFilter {
//
//	 @Autowired
//	 private JwtUtil jwtUtil;
//
//	 @Override
//	 protected void doFilterInternal(HttpServletRequest request,
//	                                 HttpServletResponse response,
//	                                 FilterChain chain)
//	         throws ServletException, IOException {
//
//	     final String authHeader = request.getHeader("Authorization");
//
//	     String token = null;
//	     if (authHeader != null && authHeader.startsWith("Bearer ")) {
//	         token = authHeader.substring(7);
//	     }
//
//	     if (token != null && jwtUtil.validateToken(token)) {
//	         Claims claims = jwtUtil.getClaims(token);
//	         String username = claims.getSubject();
//
//	         UsernamePasswordAuthenticationToken authentication =
//	                 new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
//
//	         authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//	         SecurityContextHolder.getContext().setAuthentication(authentication);
//	     }
//
//	     chain.doFilter(request, response);
//	 }
//	}

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                username = jwtUtil.getClaims(token).getSubject();
            }
        }

        // If username is valid and authentication is not already set
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities() // ✅ Pass actual roles
                    );

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // ✅ Set the authentication context
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}

