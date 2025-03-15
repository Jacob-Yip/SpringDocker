package com.demo.spring_docker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_docker.assembler.UserAssembler;
import com.demo.spring_docker.dao.UserService;
import com.demo.spring_docker.entity.User;
import com.demo.spring_docker.exception.InvalidDataException;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	private static final String INVALID_MSG = "{\"error\": \"%s\", \"%s\": \"%s\"}";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAssembler userAssembler;
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<?> invalidDataHandler(InvalidDataException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(String.format(INVALID_MSG, ex.getMessage(), ex.getDataName(), ex.getData()));
	}
	
	@GetMapping("/all")
	public CollectionModel<EntityModel<User>> getAll() {
		return userAssembler.toCollectionModel(userService.findAll());
	}
	
	@GetMapping("/{id}")
	public EntityModel<User> getByID(@PathVariable("id") long id) {
		User user;
		try {
			user = userService.findById(Long.valueOf(id));
		} catch (Exception e) {
			user = null;
		}
		
		return userAssembler.toModel(user);
	}
	
	@DeleteMapping("/all")
	public CollectionModel<EntityModel<User>> deleteAll() {
		List<User> allUsers = userService.findAll();
		
		userService.deleteAll();
		
		return userAssembler.toCollectionModel(allUsers);
	}
	
	@DeleteMapping("/{id}")
	public EntityModel<User> deleteOne(@RequestParam(value = "id", required = true) long userID) throws Exception {
		
		User user = userService.findById(Long.valueOf(userID));
		
		if(user == null) {
			throw new Exception("No such user: " + userID);
		}
		
		return userAssembler.toModel(user);
	}
	
	@PostMapping
	public EntityModel<User> newUser(@RequestBody @Valid User user) {
		User savedUser = userService.save(user);
		
		return userAssembler.toModel(savedUser);
	}
	
}
