package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.dao.BankingDao;
import com.lti.dto.AdminDto;
import com.lti.dto.BeneficaryDto;
import com.lti.model.Account;
import com.lti.model.Admin;
import com.lti.model.Beneficary;
import com.lti.model.Customer;
import com.lti.model.Transaction;

@Controller
public class BankingServiceImpl implements BankingService{
	
	@Autowired
	BankingDao bankingdao;

	public Customer addorUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return bankingdao.addorUpdateCustomer(customer);
	}

	public boolean loginCustomer(int custId, String loginPassword) {
		// TODO Auto-generated method stub
		return bankingdao.loginCustomer(custId, loginPassword);
	}

	public Account UpdateAccount(Account account,int custid){
		return bankingdao.UpdateAccount(account,custid);
	}
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return bankingdao.addAccount(account);
	}

	public Customer findCustomerById(int custId) {
		// TODO Auto-generated method stub
		return bankingdao.findCustomerById(custId);
	}

	public void addAnAdmin(Admin admin) {
		// TODO Auto-generated mDtoethod stub
		bankingdao.addAnAdmin(admin);
	}

	public boolean loginAdmin(int aId, String aPwd) {
		// TODO Auto-generated method stub
		return bankingdao.loginAdmin(aId, aPwd);
	}

	public Account findAccountByNo(int accNo) {
		// TODO Auto-generated method stub
		return bankingdao.findAccountByNo(accNo);
	}

	public List<Beneficary> findBeneficaryAccountByNo(int accNo) {
		// TODO Auto-generated method stub
		return bankingdao.findBeneficaryAccountByNo(accNo);
	}

	public List<Account> viewAllAccounts() {
		// TODO Auto-generated method stub
		return bankingdao.viewAllAccounts();
	}

	public Customer aprroveCustomerbyId(int custId) {
		// TODO Auto-generated method stub
		return bankingdao.aprroveCustomerbyId(custId);
	}

	public List<Customer> unapprovedCustomerList() {
		// TODO Auto-generated method stub
		return bankingdao.unapprovedCustomerList();
	}

	public List<Customer> approvedCustomerList() {
		// TODO Auto-generated method stub
		return bankingdao.approvedCustomerList();
	}

	public Beneficary addBenefiary(BeneficaryDto beneficarydto) {
		// TODO Auto-generated method stub
		return bankingdao.addBenefiary(beneficarydto);
	}

	public List<Account> findAccountsByCustId(int custId) {
		// TODO Auto-generated method stub
		return bankingdao.findAccountsByCustId(custId);
	}

	

	public Account addAmountToAccNO(int accNo, double amount) {
		// TODO Auto-generated method stub
		return bankingdao.addAmountToAccNO(accNo, amount);
	}

	public Account deductAmountfromAccNO(int accNo, double amount) {
		// TODO Auto-generated method stub
		return bankingdao.deductAmountfromAccNO(accNo, amount);
	}

	public Transaction addATransaction(int ToAcc ,int fromAcc ,double amt) {
		return bankingdao.addATransaction( ToAcc , fromAcc ,amt);
	}

	public List<Transaction> viewAllTransactionByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return bankingdao.viewAllTransactionByDate(date);
	}

	

	public List<Beneficary> viewAllBeneficaryofUser(int i) {
		// TODO Auto-generated method stub
		return bankingdao.viewAllBeneficaryofUser(i);
	}

}
