package com.demo.spring_docker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring_docker.entity.User;
import com.demo.spring_docker.exception.InvalidIDException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long userID) throws Exception {
		if(userID == null) {
			throw new InvalidIDException("Null id in findById()", userID);
		}
		
		return userRepository.findById(userID).orElseThrow(() -> new Exception("No such user: " + userID.toString()));
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void deleteById(Long userID) {
		if(userID == null) {
			throw new InvalidIDException("Null id in deleteById()", userID);
		}
		
		userRepository.deleteById(userID);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
}
