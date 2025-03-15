package com.demo.spring_docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDockerApplication {
	private final static Logger log = LoggerFactory.getLogger(SpringDockerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDockerApplication.class, args);
	}

}
