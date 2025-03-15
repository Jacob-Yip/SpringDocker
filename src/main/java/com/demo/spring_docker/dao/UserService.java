package com.demo.spring_docker.dao;

import java.util.List;

import com.demo.spring_docker.entity.User;

public interface UserService {
	public long count();
	public List<User> findAll();
	public User findById(Long userID) throws Exception;
	public void deleteAll();
	public void deleteById(Long userID);
	public User save(User user);
}
