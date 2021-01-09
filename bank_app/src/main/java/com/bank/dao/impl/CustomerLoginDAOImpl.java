package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.CustomerLoginDAO;
import com.bank.dao.dbutil.PostgresSqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Login;

public class CustomerLoginDAOImpl implements CustomerLoginDAO{

	@Override
	public int validLogin(String username, String password) throws BusinessException {
		int customer_id = 0;
		String inputUsername = username;
		String inputPassword = password;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT customer_id, password FROM bank.login WHERE username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, inputUsername);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer_id = resultSet.getInt("customer_id");
				if (inputPassword.equals(resultSet.getString("password"))) {
					return customer_id;
				}	
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take this line off when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return customer_id;
	}

	@Override
	public int createLogin(Login login) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){	
			String sql = "INSERT INTO bank.login(username, password, customer_id) VALUES(?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setInt(3, login.getCustomer_id());
			c = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take this line off when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return c;
	}
	
}
