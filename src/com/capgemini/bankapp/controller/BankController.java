package com.capgemini.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapp.client.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.service.BankAccountService;

@Controller
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankAccountService service;
	
	
	@RequestMapping("/new_account")
	public String inputPage() {
		return "new_account";
	}
	@RequestMapping("/new")
	public String addNewAccount(@RequestParam("customer_name")  String personName,@RequestParam("account_type") String accountType,@RequestParam("account_balance") double personBalance) {
		//double bal=Double.parseDouble(personBalance);
		BankAccount account = new BankAccount(personName,accountType,personBalance);
		service.addNewBankAccount(account);
		return "index";
	}
	
	@RequestMapping("/withdrawPage")
	public String withdrawPage() {
		return "withdrawls";
	}
	@RequestMapping("/withdrawls")
	public String withdraw(@RequestParam("number") long accountId, @RequestParam("amount") double personBalance) {
		try {
			service.withdraw(accountId, personBalance);
		} catch (AccountNotFoundException | LowBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	
	@RequestMapping("/depositPage")
	public String depositsPage() {
		return "deposits";
	}
	@RequestMapping("/deposit")
	public String deposit(@RequestParam("number") long accountId, @RequestParam("amount") double personBalance) {
		try {
			service.deposit(accountId, personBalance);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/fundsPage")
	public String fundsPage() {
		return "funds";
	}
	@RequestMapping("/funds")
	public String funds(@RequestParam("number1") long accountId,@RequestParam("number2") long accountId2, @RequestParam("amount") double personBalance) {
		try {
			service.fundTransfer(accountId, accountId2, personBalance);
		} catch (AccountNotFoundException | LowBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/cbPage")
	public String cbPage() {
		return "cb";
	}
	@RequestMapping("/cb")
	public String cb(@RequestParam("number") long accountId) {
		try {
			service.checkBalance(accountId);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	
	@RequestMapping("/dadPage")
	public String dadPage() {
		return "dad";
	}
	
	
	@RequestMapping("/dad")
	public String displayAllAccountDetails() {
		service.findAllBankAccountsDetails();
		return "display1.jsp";
		
	}
	@RequestMapping("/deletePage")
	public String delete() {
		return "delete";
		
	}
	@RequestMapping("/delete")
	public String deleteBankAccoount(@RequestParam("number") long accountId) {
		try {
			service.deleteBankAccount(accountId);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
		
	}
	
	/*
	 * @RequestMapping("/updatePage") public String update() { return "update";
	 * 
	 * }
	 * 
	 * @RequestMapping("/update") public String
	 * updateBankAccount(@RequestParam("number") long accountId) {
	 * service.updateBankAccountDetails(accountId, accountHolderName, accountType);
	 * return "index"; }
	 */
	
	@RequestMapping("/searchAccountPage")
	public String searchAccount() {
		return "searchAccount";
		
	}
	@RequestMapping("/searchAccount")
	public String searchBankAccount(@RequestParam("number") long accountId) {
		try {
			service.searchAccountDetails(accountId);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "searchDisplay";
	}
}
	
