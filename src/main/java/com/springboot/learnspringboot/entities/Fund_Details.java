package com.springboot.learnspringboot.databaseConnect;



import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fund_details")
public class Fund_Details {
	
	@Id 
	private int id = 5;
	private String fund_Name;
	private double rate;
	private int months;
	
	public Fund_Details() {
		super();
	}
	
	public Fund_Details(int id,String fund_Name, double rate, int months) {
		super();
		this.id = id;
		this.fund_Name = fund_Name;
		this.rate = rate;
		this.months = months;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFund_Name() {
		return fund_Name;
	}
	public void setFund_Name(String fund_Name) {
		this.fund_Name = fund_Name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getMonths() {
		return months;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fund_Details other = (Fund_Details) obj;
		return id == other.id;
	}

	public void setMonths(int months) {
		this.months = months;
	}
	@Override
	public String toString() {
		return "Fund_Details [id=" + id + ", fund_Name=" + fund_Name + ", rate=" + rate + ", months=" + months + "]";
	}
}
