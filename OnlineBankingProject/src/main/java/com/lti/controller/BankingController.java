package com.lti.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminDto;
import com.lti.dto.BeneficaryDto;
import com.lti.dto.CustomerLoginDto;
import com.lti.dto.TransactionDto;
import com.lti.model.Account;
import com.lti.model.Admin;
import com.lti.model.Beneficary;
import com.lti.model.Customer;
import com.lti.model.Transaction;
import com.lti.service.BankingService;

@RestController
@CrossOrigin
public class BankingController {

	@Autowired
	BankingService bankingservice;
	
	@RequestMapping(value="/addorupdatecust", method= RequestMethod.POST)
	public Customer addorUpdateCustomer(@RequestBody Customer customer) {
		// TODO Auto-generated method stub
		return bankingservice.addorUpdateCustomer(customer);
	}

	
	@RequestMapping(value="/addacct",method= RequestMethod.POST)
	public Account addAccount(@RequestBody Account account,@RequestParam("custid")int custid){
		account.setCustomer(findCustomerById(custid));
		return bankingservice.addAccount(account);
	}
	
	@RequestMapping(value="/updateacct",method= RequestMethod.POST)
	public Account UpdateAccount(@RequestBody Account account,@RequestParam("custid")int custid){
		return bankingservice.UpdateAccount(account,custid);
	}

	@GetMapping(value="/findcustbyid")
	public Customer findCustomerById(@RequestParam("custId") int custId) {
		// TODO Auto-generated method stub
		return bankingservice.findCustomerById(custId);
	}
	

	@RequestMapping(value="/findaccountbyno",method= RequestMethod.POST)
	public Account findAccountByNo(@RequestParam("accNo") int accNo){   //by acc no
		return bankingservice.findAccountByNo(accNo);
	}

	@RequestMapping(value="/viewallaccts",method= RequestMethod.POST)
	public List<Account>  viewAllAccounts(){
		
		return bankingservice.viewAllAccounts();
	}

	@RequestMapping(value="/AddBeneficary",method=RequestMethod.POST)
	public Beneficary addBenefiary(@RequestBody BeneficaryDto beneficarydto){
		return bankingservice.addBenefiary(beneficarydto);
	}
	@RequestMapping(value="/addTranscation",method=RequestMethod.POST)
	public Transaction makeTransaction(@RequestBody TransactionDto tranDto){
		return bankingservice.addATransaction(tranDto.getAccTo(),tranDto.getAccFrom(),tranDto.getAmount());
	}
	
	
	@RequestMapping(value="/viewAllTransactionByDate",method=RequestMethod.POST)  //ASK SIR
	public List<Transaction> viewAllTransactionByDate(@RequestParam LocalDate date) {
		return bankingservice.viewAllTransactionByDate(date);
	}

	@RequestMapping(value = "/addanadmin", method = RequestMethod.POST) // done
	public void addAnAdmin(@RequestBody Admin admin) {
		// TODO Auto-generated method stub
		bankingservice.addAnAdmin(admin);
	}
	

	// DTO

	@PostMapping(value = "/admindto") 
	public boolean loginAdmin(@RequestBody AdminDto admin) {
		return bankingservice.loginAdmin(admin.getaId(), admin.getaPwd());
	}


	@PostMapping(value = "/logindto")
	public boolean loginCustomer(@RequestBody CustomerLoginDto loginDto)// done
	{
		// TODO Auto-generated method stub
		return bankingservice.loginCustomer(loginDto.getCustId(), loginDto.getLoginPassword());
	}
	
	
	@GetMapping(value="findAccountsByCustId")
	List<Account> findAccountsByCustId(@RequestParam("custId")int custId){
		return bankingservice.findAccountsByCustId(custId);
	}
	
	@GetMapping(value = "/viewAllBeneficaryofUser")    
	List<Beneficary> viewAllBeneficaryofUser(@RequestParam("custId")int i){
		return bankingservice.viewAllBeneficaryofUser(i);
		
	}
	
	@PostMapping(value = "/aprrovecustbyid")    
	public Customer aprroveCustomerbyId(@RequestParam("custId") int custId) 
	{
		// TODO Auto-generated method stub
		return bankingservice.aprroveCustomerbyId(custId);
	}
	@GetMapping(value = "/unapprovedCustomerList")    
	public List<Customer> unapprovedCustomerList() {
		// TODO Auto-generated method stub
		return bankingservice.unapprovedCustomerList();
	}

	@GetMapping(value ="/approvedCustomerList")    
	public List<Customer> approvedCustomerList() {
		// TODO Auto-generated method stub
		return bankingservice.approvedCustomerList();
	}

}
