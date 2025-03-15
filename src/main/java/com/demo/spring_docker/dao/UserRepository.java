package com.demo.spring_docker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring_docker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
