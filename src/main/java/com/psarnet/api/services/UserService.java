package com.psarnet.api.services;

import java.util.ArrayList;

import com.psarnet.api.entities.User;
import com.psarnet.api.entities.input.UserLogin;

public interface UserService {

	public int createUser(User users);
	
	public ArrayList<User> findUserByName(String username);
	
	public ArrayList<User> getAllUsers();
	
	public ArrayList<User> getUserById(int userid);
	
	public int updateUser(User users);

	public int deleteUserById(int userid);
	
	
}
