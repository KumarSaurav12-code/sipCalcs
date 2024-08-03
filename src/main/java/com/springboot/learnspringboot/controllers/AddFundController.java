package com.springboot.learnspringboot.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.learnspringboot.databaseConnect.FundDetailsRepository;
import com.springboot.learnspringboot.databaseConnect.FundDetailsService;
import com.springboot.learnspringboot.entities.Fund_Details;
import com.springboot.learnspringboot.javaClasses.Projection;

@Controller
@SessionAttributes("model")
public class AddFundController {
	
	@Autowired
	private FundDetailsService fundDetailsService;
	
	@GetMapping("/welcome/addFund")
	public String addFundPage() {
		return "addFund";
	}
	
	@PostMapping("/welcome/addFund")
	public String addFund(@RequestParam String fundName,
			@RequestParam Integer rates,@RequestParam Integer years, ModelMap model) {
		String userName = (String) model.getAttribute("userName");
		Fund_Details addFund = new Fund_Details(fundName, rates, rates,userName);
		fundDetailsService.createFund_Details(addFund);
		return "welcome";
	}
}
