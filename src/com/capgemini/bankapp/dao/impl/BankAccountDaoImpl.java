package com.capgemini.bankapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.client.BankAccount;
import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.map.BankMapper;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){
		 this.jdbcTemplate = jdbcTemplate; 
	}


	@Override
	public double getBalance(long accountId)throws AccountNotFoundException {
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id=?";
		double balance = -1;
		try{
			balance=jdbcTemplate.queryForObject(query, new Object[]{accountId},Double.class);
			
		}catch(Exception e){
			throw new AccountNotFoundException("BankAccount doesn't exist....");
		}
		return balance;
	}

	@Override
	public void updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankaccounts SET account_balance='"+newBalance+"' WHERE account_id='"+accountId+"' ";
		jdbcTemplate.update(query);
		
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		String query = "DELETE FROM bankaccounts WHERE account_id=" + accountId;
		int result=jdbcTemplate.update(query);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public boolean addNewBankAccount(BankAccount account) {

		String query = "INSERT INTO bankaccounts (customer_name,account_type,account_balance) VALUES ('"+account.getAccountHolderName()+"','"+account.getAccountType()+"','"+account.getAccountBalance()+"')";
		int result=jdbcTemplate.update(query);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public List<BankAccount> findAllBankAccountsDetails() {
		String query = "SELECT * FROM bankaccounts";
		List <BankAccount> account = jdbcTemplate.query(query, new BankMapper());
		return account;
	}

	@Override
	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException {
		String query = "SELECT * FROM bankaccounts WHERE account_id=?";
		BankAccount account = null;
		try{
			account = jdbcTemplate.queryForObject(query,new Object[]{accountId},new BankMapper());
		}catch(Exception e){
			throw new AccountNotFoundException("BankAccount doesn't exist....");	
		}
		return account;
	}

	@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType)throws AccountNotFoundException {

		String query = "UPDATE bankaccounts SET customer_name='"+accountHolderName+"',account_type='"+accountType+"' WHERE account_id='"+accountId+"' ";
			int result=-1;
			
			result = jdbcTemplate.update(query);
			
			if(result>0){
				return true;
			}else{
				throw new  AccountNotFoundException("BankAccount doesn't exist....");
			}		
				
	}

}
