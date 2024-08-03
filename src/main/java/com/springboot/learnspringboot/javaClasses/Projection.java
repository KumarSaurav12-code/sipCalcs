package com.springboot.learnspringboot.javaClasses;

public class Projection {
	private  int months;
	private  double rate = 5;
	private  String fundName;
	private double amount;
	private double projectedValue;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public  int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public  double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public  String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public double getProjectedValue() {
		return projectedValue;
	}
	public void setProjectedValue(double projectedValue) {
		this.projectedValue = projectedValue;
	}
	public Projection(int months, double rate, String fundName, double amount) {
		super();
		this.months = months;
		this.rate = rate;
		this.fundName = fundName;
		this.amount = amount;
		this.projectedValue = this.calculateProjectedValue();
	}
	
	public double calculateProjectedValue() {
		double projectedVal = 0d;
		for(int i = 1;i<=this.months;i++) {
			projectedVal = projectedVal + this.amount;
			projectedVal = projectedVal + (projectedVal * this.rate) / 100;
//			System.out.println(projectedVal);
		}
		return Math.round(projectedVal);
	}
	
	public double getTotalInvestmentAmount() {
		return this.amount*this.months;
	}
	@Override
	public String toString() {
		return "Projection [months=" + months + ", rate=" + rate + ", fundName=" + fundName + ", projectedValue="
				+ projectedValue + ", amount=" + amount + "]";
	}
	
	
}
