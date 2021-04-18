package com.lti.dto;

public class TransactionDto {
	int accFrom;
	int accTo;
	double amount;
	
	public int getAccFrom() {
		return accFrom;
	}
	public void setAccFrom(int accFrom) {
		this.accFrom = accFrom;
	}
	public int getAccTo() {
		return accTo;
	}
	public void setAccTo(int accTo) {
		this.accTo = accTo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
