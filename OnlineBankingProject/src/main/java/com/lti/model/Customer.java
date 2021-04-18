package com.lti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_customersss")
public class Customer {
	@Id
	@SequenceGenerator(name="customer_seq",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_seq")
	int custId;
	int custAge;
	String custName;
	String parentsName;
	String permanentAddress; 
	String residentialAddress;
	String PAN;
	String Aadhar;
	String mobileNumber;
	String emailID;
	boolean isApproved=false;
	String loginPassword;
	
	
	@OneToMany(mappedBy="customer")
	List<Beneficary> benificary;

	
	@OneToMany(mappedBy="customer")
	List<Account> account;


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public int getCustAge() {
		return custAge;
	}


	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getParentsName() {
		return parentsName;
	}


	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}


	public String getPermanentAddress() {
		return permanentAddress;
	}


	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}


	public String getResidentialAddress() {
		return residentialAddress;
	}


	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}


	public String getPAN() {
		return PAN;
	}


	public void setPAN(String pAN) {
		PAN = pAN;
	}


	public String getAadhar() {
		return Aadhar;
	}


	public void setAadhar(String aadhar) {
		Aadhar = aadhar;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	@JsonIgnore
	public List<Beneficary> getBenificary() {
		return benificary;
	}


	public void setBenificary(List<Beneficary> benificary) {
		this.benificary = benificary;
	}

	@JsonIgnore
	public List<Account> getAccount() {
		return account;
	}


	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	

}

