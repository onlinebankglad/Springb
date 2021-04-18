package com.lti.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dto.AdminDto;
import com.lti.dto.BeneficaryDto;
import com.lti.model.Account;
import com.lti.model.Admin;
import com.lti.model.Beneficary;
import com.lti.model.Customer;
import com.lti.model.Tmodes;
import com.lti.model.Transaction;

@Repository
public class BankingDaoImpl implements BankingDao{
	
	@PersistenceContext
	EntityManager em; /*//  The entity manager implements the API and encapsulates all of them within a single interface.
	Entity manager is used to read, delete and write an entity.
	An object referenced by an entity is managed by entity manager.*/
	
	
	
	
	
	@Transactional
	public Customer addorUpdateCustomer(Customer customer){
		
		Customer cust=em.merge(customer);//update when there is an existing field/data or make new entry in table
		return cust;
	}
	
	
	public boolean loginCustomer(int custId, String loginPassword) {

		String jql = "select c from Customer c where c.custId=:cId and c.loginPassword=:cpass";

		TypedQuery<Customer> query = em.createQuery(jql, Customer.class);
		query.setParameter("cId", custId);
		query.setParameter("cpass", loginPassword);

		Customer customer = null;
		try {
			customer = query.getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (customer == null)
			return false;

		return true;

	}

	
	@Transactional
	public Account addAccount(Account account){
		Account acc=em.merge(account);
		return acc;
	}
	
	@Transactional
	public Account UpdateAccount(Account account,int custid){
		String jpql="select a from Account a where a.customer.custId=:custid and a.accNo=:accNo";
		TypedQuery<Account> query= em.createQuery(jpql, Account.class);
		query.setParameter("custid", custid);
		query.setParameter("accNo", account.getAccNo());
		Account acc= query.getSingleResult();
		
		Account accPersisted=null;
		if(acc!=null){
			acc.setAccBal(account.getAccBal());
			accPersisted= addAccount(acc);
		}
		return accPersisted;
	}
	
	

   
	@Transactional
	public Beneficary addBenefiary(BeneficaryDto beneficarydto){
		Beneficary b= new Beneficary();
		Account a= findAccountByNo(beneficarydto.getAccNo());
		Customer c= findCustomerById(beneficarydto.getCustId());
		b.setCustomer(c);
		b.setAccount(a);
		b.setBnickName(beneficarydto.getBnickName());
		b.setbName(a.getCustomer().getCustName());
		
		
		return em.merge(b);
		
	
	
}
	public Customer findCustomerById(int custId){
		return em.find(Customer.class, custId);
	}
	
	/*@Transactional
	public Account addUpdateAccount(Address address, int userId) {
	User user=findUserById(userId);
	Address addressPersisted=null;
	if(user!=null){
	addressPersisted = em.merge(address);
	addressPersisted.setUser(user);
	}

	 return addressPersisted;
	}*/
	
	
	
	public Customer findCustomerIdbyAccNo(int AccNo){
		Account account= em.find(Account.class,AccNo);
		return account.getCustomer();
		
	}
	
	
	@Transactional
	public void addAnAdmin(Admin admin){
		em.persist(admin);
	}

	public boolean loginAdmin(int aId, String aPwd) {

		String jql = "select a from Admin a where a.aId=:adminid and a.aPwd=:apass";

		TypedQuery<Admin> query = em.createQuery(jql, Admin.class);
		query.setParameter("adminid", aId);
		query.setParameter("apass", aPwd);

		Admin admin = null;
		try {
			admin = query.getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (admin == null)
			return false;

		return true;

	}
	
	public Account findAccountByNo(int accNo){
		return em.find(Account.class, accNo); //find() is an inbuild function
	}
	
	
	public List<Account> viewAllAccounts(){
	
		String jpql="Select a from Account a";//select * from Account 
		
		TypedQuery<Account> query=em.createQuery(jpql, Account.class);
		List<Account> accs= query.getResultList();

		return accs;

	}
	
	
	@Transactional
	public Customer aprroveCustomerbyId(int custId){
		Customer customer=findCustomerById(custId);
		customer.setApproved(true);
		return addorUpdateCustomer(customer);

	}
	
	
	public List<Customer> unapprovedCustomerList(){
		 String jpql="select c from Customer c where c.isApproved=0";
			TypedQuery<Customer> query=em.createQuery(jpql, Customer.class);
	        return  query.getResultList();
		
	}
	
	public List<Customer> approvedCustomerList(){
		 String jpql="select c from Customer c where c.isApproved=1";
			TypedQuery<Customer> query=em.createQuery(jpql, Customer.class);
	        return  query.getResultList();
		
	}
	
	
	
	public List<Account> findAccountsByCustId(int custId){
		String jqpl="select a from Account a where a.customer.custId=:cId";
		
		TypedQuery<Account> query=em.createQuery(jqpl, Account.class);
	    query.setParameter("cId", custId);
	    
	    List<Account> accts=query.getResultList();
	    return accts;
	}
	
	public List<Beneficary> viewAllBeneficaryofUser(int custId){
		String jqpl="select b from Beneficary b where b.customer.custId=:cId";
		TypedQuery<Beneficary> query=em.createQuery(jqpl, Beneficary.class);
	    query.setParameter("cId", custId);
	    List<Beneficary> accts=query.getResultList();

	    return accts;

	}
	
	public List<Beneficary> findBeneficaryAccountByNo(int OwneraccNo){
		String jpql="Select b from Beneficary b where b.account.accNo=:accNo";
		TypedQuery<Beneficary> query= em.createQuery(jpql, Beneficary.class);
		query.setParameter("accNo", OwneraccNo);
		List <Beneficary> bfcs=query.getResultList();
		return query.getResultList(); //find() is an inbuild function
	}
	
	
	public Account addAmountToAccNO(int accNo, double amount){
		Account acc =em.find(Account.class, accNo);
		double bal=acc.getAccBal();
		bal=bal+amount;
		acc.setAccBal(bal);
		return addAccount(acc);	
	}

	
	
	public Account deductAmountfromAccNO(int accNo,double amount){
		
		Account acc =em.find(Account.class, accNo);
		double bal=acc.getAccBal();
		bal=bal-amount;
		acc.setAccBal(bal);
		return addAccount(acc);
	}
	

	@Transactional
	public Transaction addATransaction(int ToAcc ,int fromAcc ,double amt){

		Account fromacc = deductAmountfromAccNO(fromAcc, amt);
		Account toAcc  = addAmountToAccNO(ToAcc, amt);
		Account toacc=findAccountByNo(ToAcc);
        	  Transaction transaction1= new Transaction();
              transaction1.setAccount(fromacc);
              transaction1.setToAccNO(toacc.getAccNo());
              transaction1.setAmount(amt);
              transaction1.setTmodes(Tmodes.NEFT);
              transaction1.settDate(LocalDate.now());
             Transaction transaction2= em.merge(transaction1);
              return transaction2;
        	
		
	
      
    
	}
	
	
	public List<Transaction> viewAllTransactionByDate(LocalDate date){
		String jqpl="select t from Transaction t where tDate=:date";
		
		TypedQuery<Transaction> query=em.createQuery(jqpl, Transaction.class);
	    query.setParameter("date", date);
	    
	    List<Transaction> bfcs=query.getResultList();
	    return bfcs;
	}


	public Beneficary addBenefiary(Beneficary beneficary, int custId) {
		// TODO Auto-generated method stub
		return null;
	}



	



}
