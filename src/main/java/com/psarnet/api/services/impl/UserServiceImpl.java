package com.psarnet.api.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.User;
import com.psarnet.api.entities.input.UserLogin;
import com.psarnet.api.repositories.UserRopository;
import com.psarnet.api.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRopository userRepository;
	
	@Override
	public int createUser(User users) {
		return userRepository.createUser(users);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public ArrayList<User> getUserById(int userid) {
		return userRepository.getUserById(userid);
	}

	@Override
	public int updateUser(User users) {
		return userRepository.updateUser(users);
	}

	@Override
	public int deleteUserById(int userid) {
		return userRepository.deleteUserById(userid);
	}
	
	@Override
	public ArrayList<User> findUserByName(String username) {
		return userRepository.findUserByName(username);
	}

	
}
