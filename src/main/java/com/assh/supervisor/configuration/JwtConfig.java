package com.assh.supervisor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//@Configuration
//public class JwtConfig {
//	
//	@Autowired
//	private JwtFilter jwtFilter;
//
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		System.out.println("yyyyyyyyyyyyyyyyyyyyyyy");
//        http.csrf().disable()
//            .authorizeHttpRequests()
////            .requestMatchers("/SupervisorSignsIn/auth/login/**").permitAll()
////            .requestMatchers("/SupervisorSignsIn-0.0.1-SNAPSHOT/auth/login/**").permitAll()
////               .requestMatchers("/auth/login/**").permitAll()
////                .requestMatchers("/position/**").permitAll()
//            .requestMatchers("/auth/login/**").permitAll()
//                .anyRequest().authenticated()
//            .and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//	
//	 @Bean
//	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//	        return config.getAuthenticationManager();
//	    }
//
//	    @Bean
//	    public UserDetailsService userDetailsService(CustomUserDetailsService customUserDetailsService) {
//	        return customUserDetailsService;
//	    }
//	
//}

@Configuration
@EnableWebSecurity
public class JwtConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	System.out.println(")))))))))))))))))))))))0000000");
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/auth/login/**").permitAll() // allow login
            .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

