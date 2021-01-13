package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.AccountDAO;
import com.bank.dao.dbutil.PostgresSqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Account;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public int createAccount(Account account) throws BusinessException {

		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){	
			String sql = "insert into bank.account(account_id, customer_id, account_type, balance) VALUES(?, ?, ?, ?)";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account.getAccount_id());
			preparedStatement.setInt(2, account.getCustomer_id());
			preparedStatement.setString(3, account.getAccount_type());
			preparedStatement.setDouble(4, account.getBalance());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return c;
		 
	}

	@Override
	public int withdrawFromAccount(int account_id, double newBalance) throws BusinessException {
		
		int w = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "update bank.account set balance=? where account_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, newBalance);
			preparedStatement.setInt(2, account_id);
			w = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return w;
	}
	
	@Override
	public int depositToAccount(int account_id, double newBalance) throws BusinessException {
		int d = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "update bank.account set balance=? where account_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, newBalance);
			preparedStatement.setInt(2, account_id);
			d = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return d;
	}

	@Override
	public Account checkBalance(int account_id) throws BusinessException {
		Account account = null;	
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "select * from bank.account where account_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,account_id);			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				account = new Account(); 
				account.setAccount_id(resultSet.getInt("account_id"));
				account.setCustomer_id(resultSet.getInt("customer_id"));
				account.setAccount_type(resultSet.getString("account_type"));
				account.setBalance(resultSet.getDouble("balance"));		
			}else {
				throw new BusinessException("No account found with id: "+ account_id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return account;
		 
	}
	
	

}
