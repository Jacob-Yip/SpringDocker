package com.demo.spring_docker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="springdocker_user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	public User() {
		
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
