package com.springboot.learnspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class LoginController {
	
	private AuthenticationSevice authenticationSevice;
	
	private UserDetailsService userDetailsService;
	
	public LoginController(AuthenticationSevice authenticationSevice,UserDetailsService userDetailsService) {
		super();
		this.authenticationSevice = authenticationSevice;
		this.userDetailsService = userDetailsService;
	}
	
	@GetMapping("/userRoute")
	public String loginPage() {
		return "userRoute";
	}
	
	@GetMapping("/")
	public String firtsPage() {
		return "index";
	}
	
//	@RequestMapping(value="/login", method= RequestMethod.POST)
//	public String signUp(@RequestParam String firstName,
//			@RequestParam String lastName,@RequestParam String email,@RequestParam String password,
//			ModelMap model,RedirectAttributes redirectAttributes) {
//		if(firstName == null && lastName == null) {
//			return this.signIn(email, password, model, redirectAttributes);
//		}
//		User createUser = new User(firstName,lastName,email,password,"DEV");
//		if(authenticationSevice.isUserAlreadyPresent(createUser)) {
//			model.put("errorMessage", "User Already Present");
//			return "login";
//		}
//		userDetailsService.createUser(createUser);
//		if(authenticationSevice.authenticate(createUser)) {
//			model.put("firstName", firstName);
//			model.put("lastName", lastName);
//			redirectAttributes.addFlashAttribute("firstName", firstName);
//			redirectAttributes.addFlashAttribute("lastName", lastName);
//			return "redirect:/welcome"; 
//		}
//		
//		model.put("errorMessage", "Invalid Credintials! Please contact admin team.");
//		return "login";
//	}
	
//	public String signIn(@RequestParam String email,@RequestParam String password,
//			ModelMap model,RedirectAttributes redirectAttributes) {
//		if(model == null) {
//			return "login";
//		}
//		User currentUser = userDetailsService.getUserByUserName(email);
//		if(!authenticationSevice.isUserAlreadyPresent(currentUser)) {
//			model.put("errorMessage", "No User Present Please Sign Up");
//			return "login";
//		}
//		userDetailsService.createUser(currentUser);
//		if(authenticationSevice.authenticate(currentUser)) {
//			model.put("firstName", currentUser.getFirstName());
//			model.put("lastName", currentUser.getLastName());
//			redirectAttributes.addFlashAttribute("firstName", currentUser.getFirstName());
//			redirectAttributes.addFlashAttribute("lastName", currentUser.getLastName());
//			return "redirect:/welcome"; 
//		}
//		
//		model.put("errorMessage", "Invalid Credintials! Please contact admin team.");
//		return "login";
//	}
}
