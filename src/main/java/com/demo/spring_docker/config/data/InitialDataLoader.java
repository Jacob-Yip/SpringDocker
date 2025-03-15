package com.demo.spring_docker.config.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.spring_docker.dao.UserService;
import com.demo.spring_docker.entity.User;

@Configuration
@Profile("default")
public class InitialDataLoader {
	private final static Logger log = LoggerFactory.getLogger(InitialDataLoader.class);
	
	private static final User[] USERS = {
			new User("name_1", "email_1"), 
			new User("name_2", "email_2")
	};
	
	@Autowired
	private UserService userService;
	
	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			// Seed the database
			if(userService.count() > 0) {
				// Database is already seeded
				log.info("Database is seeded already");
			} else {
				for(User user: USERS) {
					userService.save(user);
				}
			}
			
			log.info("Number of users: " + userService.count());
			log.info("Database seeded successfully");
		};
	}
}
