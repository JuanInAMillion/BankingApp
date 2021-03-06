package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bank.dao.CustomerDAO;
import com.bank.dao.dbutil.PostgresSqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	
	@Override
	public Customer customerVerifyLogin(String email, String password) throws BusinessException {
		Customer customer= null;
		
		try ( Connection connection = PostgresSqlConnection.getConnection() ) {
			String sql = "select * from bank.customer where email = ? and password = ? and status ='active' ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);	
			ResultSet resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ) {
				customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getLong("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customer.setStatus(resultSet.getString("status"));
			} 
			else
				throw new BusinessException("You either entered a wrong email or password, or your registration is pending");
				
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		
		return customer;
	}

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){	
			String sql = "insert into bank.customer(first_name, last_name, gender, address, phone, email, password) VALUES(?, ?, ?, ?, ?, ?, ?)";	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirst_name());
			preparedStatement.setString(2, customer.getLast_name());
			preparedStatement.setString(3, customer.getGender());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setLong(5, customer.getPhone());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setString(7, customer.getPassword());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return c;
	}

}
