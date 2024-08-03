package com.springboot.learnspringboot.login;

import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.stereotype.Service;

import com.springboot.learnspringboot.databaseConnect.UserDetailsService;
import com.springboot.learnspringboot.entities.User;

@Service
public class AuthenticationSevice {

	private UserDetailsService userDetailsService;
	
	public AuthenticationSevice(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	public boolean authenticate(User user) {
		User currentUser = userDetailsService.getUserByUserName(user);
		if(currentUser != null && currentUser.equals(user)) {
			return true;
		}else {
			return false;
		} 
	}
	
	public boolean isUserAlreadyPresent(User user) {
		if(userDetailsService.getUserByUserName(user) == null) {
			return false;
		}else {
			return true;
		}
	}
}
