package com.capgemini.bankapp.map;

import com.capgemini.bankapp.client.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BankMapper implements RowMapper<BankAccount> {

	public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
      
		BankAccount account = new BankAccount();
     		account.setAccountId(rs.getInt("account_id"));
      		account.setAccountHolderName(rs.getString("customer_name"));
      		account.setAccountType(rs.getString("account_type"));
		account.setAccountBalance(rs.getDouble("account_balance"));
      		return account;
   	}
}