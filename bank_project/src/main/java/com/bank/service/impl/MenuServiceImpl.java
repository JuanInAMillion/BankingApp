package com.bank.service.impl;

import com.bank.exception.BusinessException;
import com.bank.service.MenuService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.dbutil.PostgresSqlConnection;

public class MenuServiceImpl implements MenuService{

	@Override
	public double withdrawAmount(int account_id, double newBalance) throws BusinessException {
				double balance = searchBalance(account_id);
				
				if (newBalance > 0) {
					balance = balance - newBalance;
				}else {
					throw new BusinessException("Enter a positive number");
				}
				return balance;
	}

	@Override
	public double depositAmount(int account_id, double newBalance) throws BusinessException {
				double balance = searchBalance(account_id);
				
				if (newBalance > 0) {	
					balance = balance + newBalance;
				}else {
					throw new BusinessException("Enter a positive number");
				}
				return balance;
	}
	
	@Override
	public double searchBalance(int account_id) throws BusinessException {
		double balance = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT balance FROM bank.account WHERE account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				balance = resultSet.getDouble("balance");
			}else {
				throw new BusinessException("No bank account with account id: " + account_id);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return balance;
	}

}
