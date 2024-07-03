package com.springboot.learnspringboot.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.XmlRepositoryConfigurationSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.springboot.learnspringboot.databaseConnect.FundDetailsService;
import com.springboot.learnspringboot.databaseConnect.Fund_Details;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProjectionController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static String finalfirstName;
	private static String finallastName;
	
	@Autowired
	private FundDetailsService fundDetailsService;
	
	public ProjectionController(FundDetailsService fundDetailsService) {
		super();
		this.fundDetailsService = fundDetailsService;
	}
	
	public List<Fund_Details> getFundDetails() {
		return fundDetailsService.getAllFund_Details();
	}
	
	public void addFundDetails(Fund_Details fund_Details) {
		fundDetailsService.createFund_Details(fund_Details);
	}
	
	public void addDetailsToModel(ModelMap model) {
		ArrayList<Fund_Details> listToShow = new ArrayList<Fund_Details>();
		listToShow.addAll(this.getFundDetails());
		model.addAttribute("fundDetails", listToShow);
	}
	
	@GetMapping("welcome")
	public String welcomePage(HttpServletRequest request,ModelMap model) {
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
		this.addDetailsToModel(model);
		return "welcome";
	}
	
	@RequestMapping(value="welcome", method= RequestMethod.POST)
	public String calculateSIPAmount(@RequestParam String fundName,
			@RequestParam String sipAmount,ModelMap model) {
		String resultString = "";
		this.addDetailsToModel(model);
		List<Fund_Details> allFundsDetails = fundDetailsService.getAllFund_Details();
		List<Fund_Details> list1 = allFundsDetails.stream().filter(e->e.getFund_Name().equalsIgnoreCase(fundName)).collect(Collectors.toList());
		double rates = list1.get(0).getRate();
		Projection projection = new Projection(60,rates,fundName,Integer.valueOf(sipAmount)); 
		double output = projection.calculateProjectedValue();
		double invAmount = projection.getTotalInvestmentAmount();
		double increaseAmount = output-invAmount;
		resultString = String.valueOf(output);
		model.put("firstName", finalfirstName);
		model.put("lastName", finallastName);
		model.put("interest", increaseAmount);
		model.put("investmentAmount", invAmount);
		model.addAttribute("outputAmount",resultString);
		return "welcome";
	}
}
