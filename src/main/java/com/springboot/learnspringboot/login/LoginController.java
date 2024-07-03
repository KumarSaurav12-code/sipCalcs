package com.springboot.learnspringboot.login;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.learnspringboot.calculation.ProjectionController;
import com.springboot.learnspringboot.databaseConnect.FundDetailsService;
import com.springboot.learnspringboot.databaseConnect.Fund_Details;

import ch.qos.logback.core.net.SyslogOutputStream;


@Controller
@SessionAttributes("model")
public class LoginController {
	
	private AuthenticationSevice authenticationSevice;
	
	private ProjectionController projectionController;
	
	public LoginController(AuthenticationSevice authenticationSevice, ProjectionController projectionController) {
		super();
		this.authenticationSevice = authenticationSevice;
		this.projectionController = projectionController;
	}
	
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST)
	public String loginPageValidate(@RequestParam String firstName,
			@RequestParam String lastName,@RequestParam String email,@RequestParam String password,
			ModelMap model,RedirectAttributes redirectAttributes) {
		if(authenticationSevice.authenticate(email, password)) {
			model.put("firstName", firstName);
			model.put("lastName", lastName);
//			ArrayList<Fund_Details> listToShow = new ArrayList<Fund_Details>();
//			listToShow.addAll(projectionController.getFundDetails());
//			model.addAttribute("fundDetails", listToShow);
//			System.out.println(model);
			redirectAttributes.addFlashAttribute("firstName", firstName);
			redirectAttributes.addFlashAttribute("lastName", lastName);
			return "redirect:/welcome"; 
		}
		
		model.put("errorMessage", "Invalid Credintials! Please contact admin team.");
		return "login";
	}
}
