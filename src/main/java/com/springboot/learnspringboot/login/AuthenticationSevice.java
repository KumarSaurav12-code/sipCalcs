package com.springboot.learnspringboot.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationSevice {

	public boolean authenticate(String email,String password) {
		boolean isEmailCorrect = email.contains("@gmail.com");
		boolean isPasswordCorrect = password.contains("Saurav");
		return isEmailCorrect && isPasswordCorrect;
	}
}
