package com.springboot.learnspringboot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.springboot.learnspringboot.entities.Fund_Details;
import com.springboot.learnspringboot.utilityfunctions.FundBasedFunction;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("model")
public class AddFundController {
	
	private static String finalfirstName;
	private static String finallastName;
	
	@Autowired
	private FundBasedFunction fundBaesdFunction;
	
	@GetMapping("/addFund")
	public String addFundPage(HttpServletRequest request,ModelMap model) {
		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap==null) {
			if(finalfirstName == null && finallastName == null) {
				return "redirect:/";
			}	
		}
		String firstName = flashMap == null ? finalfirstName : (String) flashMap.get("firstName");
		String lastName = flashMap == null ? finallastName : (String) flashMap.get("lastName");
		finalfirstName = firstName;
		finallastName = lastName;
		model.put("firstName", firstName);
		model.put("lastName", lastName);
		fundBaesdFunction.addDetailsToModel(model);
		return "addFund";
	}
	
	@PostMapping("/addFund")
	public String addFund(@RequestParam String fundName,
			@RequestParam Integer rates,@RequestParam Integer years, ModelMap model) {
		String userName = (String) model.getAttribute("userName");
		Fund_Details addFund = new Fund_Details(fundName, rates, rates,userName);
		fundBaesdFunction.createFund_Details(addFund);
		return "welcome";
	}
}
