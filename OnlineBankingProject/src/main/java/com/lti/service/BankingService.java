package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.dto.AdminDto;
import com.lti.dto.BeneficaryDto;
import com.lti.model.Account;
import com.lti.model.Admin;
import com.lti.model.Beneficary;
import com.lti.model.Customer;
import com.lti.model.Transaction;

public interface BankingService {

	Customer addorUpdateCustomer(Customer customer);

	boolean loginCustomer(int custId, String loginPassword);

	Account addAccount(Account account);

	Account UpdateAccount(Account account, int custid);

	Customer findCustomerById(int custId);

	void addAnAdmin(Admin admin);

	boolean loginAdmin(int aId, String aPwd);

	Account findAccountByNo(int accNo);

	List<Beneficary> findBeneficaryAccountByNo(int accNo);

	List<Account> viewAllAccounts();

	Customer aprroveCustomerbyId(int custId);

	List<Customer> unapprovedCustomerList();

	List<Customer> approvedCustomerList();

	Beneficary addBenefiary(BeneficaryDto beneficarydto);

	List<Account> findAccountsByCustId(int custId);


	Account addAmountToAccNO(int accNo, double amount);

	Account deductAmountfromAccNO(int accNo, double amount);

	Transaction addATransaction(int ToAcc ,int fromAcc ,double amt);

	List<Transaction> viewAllTransactionByDate(LocalDate date);

	List<Beneficary> viewAllBeneficaryofUser(int i);

}
