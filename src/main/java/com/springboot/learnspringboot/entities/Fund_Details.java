package com.springboot.learnspringboot.entities;



import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "fund_details")
public class Fund_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fund_Name;
	private double rate;
	private int months;
	private String userName;

	public Fund_Details(String fund_Name, double rate, int months, String userName) {
		this.fund_Name = fund_Name;
		this.rate = rate;
		this.months = months;
		this.userName = userName;
	}
	
	public Fund_Details() {
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
	public void setMonths(int months) {
		this.months = months;
	}
	
	@Override
	public String toString() {
		return "Fund_Details [id=" + id + ", fund_Name=" + fund_Name + ", rate=" + rate + ", months=" + months + "]";
	}
	
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fund_Name, id, months, rate);
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
		return Objects.equals(fund_Name, other.fund_Name) && id == other.id && months == other.months
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
