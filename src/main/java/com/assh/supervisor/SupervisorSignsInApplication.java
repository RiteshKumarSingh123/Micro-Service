package com.assh.supervisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SupervisorSignsInApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupervisorSignsInApplication.class, args);
	}

}

//@SpringBootApplication
//public class SupervisorSignsInApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(SupervisorSignsInApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SupervisorSignsInApplication.class, args);
//    }
//}




