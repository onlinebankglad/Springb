package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import com.lti.dto.AdminDto;
import com.lti.dto.BeneficaryDto;
import com.lti.model.Account;
import com.lti.model.Admin;
import com.lti.model.Beneficary;
import com.lti.model.Customer;
import com.lti.model.Transaction;

public interface BankingDao {

	Customer addorUpdateCustomer(Customer customer); //done

	boolean loginCustomer(int custId, String loginPassword); 

	Account addAccount(Account account); //done

	Account UpdateAccount(Account account, int custid); //done

	Customer findCustomerById(int custId); //done

	void addAnAdmin(Admin admin);

	boolean loginAdmin(int aId, String aPwd);

	Account findAccountByNo(int accNo); //done

	List<Beneficary> findBeneficaryAccountByNo(int accNo);

	List<Account> viewAllAccounts(); //done

	Customer aprroveCustomerbyId(int custId);

	List<Customer> unapprovedCustomerList();

	List<Customer> approvedCustomerList();

	Beneficary addBenefiary(BeneficaryDto beneficarydto); //done

	List<Account> findAccountsByCustId(int custId); //done


	Account addAmountToAccNO(int accNo, double amount); //done

	Account deductAmountfromAccNO(int accNo, double amount); //done

	Transaction addATransaction(int ToAcc ,int fromAcc ,double amt); //done

	List<Transaction> viewAllTransactionByDate(LocalDate date);

	List<Beneficary> viewAllBeneficaryofUser(int i);
	
}
