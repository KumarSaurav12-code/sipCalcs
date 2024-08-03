package com.springboot.learnspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.learnspringboot.databaseConnect.UserDetailsService;
import com.springboot.learnspringboot.entities.User;
import com.springboot.learnspringboot.login.AuthenticationSevice;

@Controller
@SessionAttributes("model")
public class SignUpController {
	
	private AuthenticationSevice authenticationSevice;
	
	private UserDetailsService userDetailsService;
	
	public SignUpController(AuthenticationSevice authenticationSevice,UserDetailsService userDetailsService) {
		super();
		this.authenticationSevice = authenticationSevice;
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("/signUp")
	public String signInPage() {
		return "login";
	}
	
	@RequestMapping(value="/signUp", method= RequestMethod.POST)
	public String signUp(@RequestParam String firstName,
			@RequestParam String lastName,@RequestParam String email,@RequestParam String password,
			ModelMap model,RedirectAttributes redirectAttributes) {
		User createUser = new User(firstName,lastName,email,password,"DEV");
		if(authenticationSevice.isUserAlreadyPresent(createUser)) {
			model.put("errorMessage", "User Already Present");
			return "login";
		}
		userDetailsService.createUser(createUser);
		if(authenticationSevice.authenticate(createUser)) {
			model.put("firstName", firstName);
			model.put("lastName", lastName);
			model.put("userName", email);
			redirectAttributes.addFlashAttribute("firstName", firstName);
			redirectAttributes.addFlashAttribute("lastName", lastName);
			redirectAttributes.addFlashAttribute("ModelMap", model);
			return "redirect:/welcome"; 
		}
		
		model.put("errorMessage", "Invalid Credintials! Please contact admin team.");
		return "login";
	}
}
