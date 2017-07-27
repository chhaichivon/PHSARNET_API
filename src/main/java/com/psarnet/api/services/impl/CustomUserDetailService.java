package com.psarnet.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.User;
import com.psarnet.api.services.UserService;

//@Service("customUserDetailService")
public class CustomUserDetailService /*implements UserDetailsService */{
	/*@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = userService.findUserByName(name);
		
		if(user == null)
			throw new UsernameNotFoundException("Username not found..!");
		System.out.println(user.getUsername()+" "+user.getDescription());
		return user;
	}*/
	
	
}
