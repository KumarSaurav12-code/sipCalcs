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
public class SignInController {
	
	private AuthenticationSevice authenticationSevice;

	private UserDetailsService userDetailsService;

	public SignInController(AuthenticationSevice authenticationSevice, UserDetailsService userDetailsService) {
		super();
		this.authenticationSevice = authenticationSevice;
		this.userDetailsService = userDetailsService;
	}
	
	@GetMapping("/signIn")
	public String signInPage() {
		return "signIn";
	}

	@RequestMapping(value="/signIn", method= RequestMethod.POST)
	public String signIn(@RequestParam String email, @RequestParam String password, ModelMap model,
			RedirectAttributes redirectAttributes) {
		User currentUser = userDetailsService.getUserByUserName(email);
		if (!authenticationSevice.isUserAlreadyPresent(currentUser)) {
			model.put("errorMessage", "No User Present Please Sign Up");
			return "signIn";
		}
		userDetailsService.createUser(currentUser);
		if (authenticationSevice.authenticate(currentUser)) {
			model.put("firstName", currentUser.getFirstName());
			model.put("lastName", currentUser.getLastName());
			model.put("userName", email);
			redirectAttributes.addFlashAttribute("firstName", currentUser.getFirstName());
			redirectAttributes.addFlashAttribute("lastName", currentUser.getLastName());
			redirectAttributes.addFlashAttribute("ModelMap", model);
			return "redirect:/welcome";
		}

		model.put("errorMessage", "Invalid Credintials! Please contact admin team.");
		return "signIn";
	}
}
