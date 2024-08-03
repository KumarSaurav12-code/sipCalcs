package com.springboot.learnspringboot.databaseConnect;

import java.util.List;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.learnspringboot.entities.Fund_Details;

@Service
public class FundDetailsService {
	
	@Autowired
    private FundDetailsRepository fundDetailsRepository; 
      
    public List<Fund_Details> getAllFund_Details() { 
        return fundDetailsRepository.findAll(); 
    } 
      
    public Fund_Details getFund_DetailsById(Long id) { 
        return fundDetailsRepository.findById(id).orElse(null); 
    } 
      
    public Fund_Details createFund_Details(Fund_Details Fund_Details) { 
        return fundDetailsRepository.save(Fund_Details); 
    } 
      
    public Fund_Details updateFund_Details(Long id, Fund_Details Fund_Details) { 
        Fund_Details existingFund_Details = fundDetailsRepository.findById(id).orElse(null); 
        if (existingFund_Details != null) { 
            existingFund_Details.setFund_Name(Fund_Details.getFund_Name()); 
            existingFund_Details.setRate(Fund_Details.getRate()); 
            existingFund_Details.setMonths(Fund_Details.getMonths()); 
            return fundDetailsRepository.save(existingFund_Details); 
        } else { 
            return null; 
        } 
    } 
      
    public void deleteFund_Details(Long id) { 
        fundDetailsRepository.deleteById(id); 
    }
}
