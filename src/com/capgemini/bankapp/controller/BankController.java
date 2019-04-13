package com.capgemini.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapp.client.BankAccount;
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
	@RequestMapping("/withdrawls")
	public String withdraw(@RequestParam("number") long accountId,@RequestParam("amount") double personBalance) {
		
		return "withdrawls";
	}
	@RequestMapping("/deposits")
	public String deposits() {
		return "deposits";
	}
	@RequestMapping("/funds")
	public String funds() {
		return "funds";
		
	}
	@RequestMapping("/cb")
	public String cb() {
		return "cb";
		
	}
	
	@RequestMapping("/dad")
	public String displayAllAccountDetails() {
		return "dad";
		
	}
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
		
	}
	@RequestMapping("/update")
	public String update() {
		return "update";
		
	}
	@RequestMapping("/searchAccount")
	public String searchAccount() {
		return "searchAccount";
		
	}
}
	
